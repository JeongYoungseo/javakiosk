package screengolfKiosk;

import java.util.Scanner;

public class MembershipMenu extends Menu {
    public MembershipMenu() {
        super("회원권", new String[]{
                "3개월", "6개월", "12개월"
        });
    }
    public void selectOptions(Scanner sc) {
        System.out.println("[회원권 메뉴 - " + getName() + " 선택됨]");

        String[] typeOptions = {"주간권", "야간권", "주말권", "종일권"};
        int type = selectFromList(sc, "1. 회원권 종류 선택:", typeOptions);

        String[] durationOptions = {"1개월", "3개월", "6개월", "12개월"};
        int duration = selectFromList(sc, "2. 이용 기간 선택:", durationOptions);

        System.out.println("\n입력하신 내용이 맞습니까?");
        System.out.println("- 종류: " + typeOptions[type - 1]);
        System.out.println("- 기간: " + durationOptions[duration - 1]);

        System.out.println("1. 네, 결제합니다");
        System.out.println("2. 아니요, 다시 선택할게요");
        int confirm = sc.nextInt();
        sc.nextLine();

        if (confirm == 2) {
            System.out.println("다시 선택을 시작합니다.\n");
            selectOptions(sc);
        } else {
            System.out.println("회원권 등록이 완료되었습니다. 감사합니다!");
        }
    }

    private int selectFromList(Scanner sc, String prompt, String[] options) {
        System.out.println(prompt);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        while (true) {
            System.out.print(">> ");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice >= 1 && choice <= options.length) return choice;
            System.out.println("잘못된 선택입니다. 다시 입력하세요.");
        }
    }
}
