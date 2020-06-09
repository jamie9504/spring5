package spring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import spring.assembler.Assembler;
import spring.dto.RegisterRequest;
import spring.exception.DuplicateMemberException;
import spring.exception.MemberNotFoundException;
import spring.exception.WrongPasswordException;
import spring.service.ChangePasswordService;
import spring.service.MemberRegisterService;

public class MainForAssembler {

    private static Assembler ASSEMBLER = new Assembler();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("명령어를 입력하세요.");
            String command = bufferedReader.readLine();
            if (command.equalsIgnoreCase("exit")) {
                System.out.println("종료합니다.");
                break;
            }
            if (command.startsWith("new ")) {
                processNewCommand(command.split(" "));
                continue;
            } else if (command.startsWith("change ")) {
                processChangeCommand(command.split(" "));
                continue;
            }
            printHelp();
        }
    }

    private static void processNewCommand(String[] args) {
        if (args.length != 5) {
            printHelp();
            return;
        }
        MemberRegisterService regSvc = ASSEMBLER.getRegSvc();
        RegisterRequest req = new RegisterRequest();
        req.setEmail(args[1]);
        req.setName(args[2]);
        req.setPassword(args[3]);
        req.setConfirmPassword(args[4]);

        if (!req.isPasswordEqualToConfirmPassword()) {
            System.out.println("암호와 확인이 일치하지 않습니다.");
            return;
        }
        try {
            regSvc.regist(req);
            System.out.println("등록했습니다.");
        } catch (DuplicateMemberException e) {
            System.out.println("이미 존재하는 이메일입니다." + System.lineSeparator());
        }
    }

    private static void processChangeCommand(String[] args) {
        if (args.length != 4) {
            printHelp();
            return;
        }
        ChangePasswordService changePwdSvc = ASSEMBLER.getPwdSvc();
        try {
            changePwdSvc.changePassword(args[1], args[2], args[3]);
            System.out.println("암호를 변경했습니다." + System.lineSeparator());
        } catch (MemberNotFoundException e) {
            System.out.println("존재하지 않는 이메일입니다." + System.lineSeparator());
        } catch (WrongPasswordException e) {
            System.out.println("이메일과 암호가 일치하지 않습니다." + System.lineSeparator());
        }
    }

    private static void printHelp() {
        System.out.println();
        System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
        System.out.println("명령어 사용법:");
        System.out.println("new 이메일 이름 암호 암호확인");
        System.out.println("change 이메일 현재비번 변경비번");
        System.out.println();
    }
}
