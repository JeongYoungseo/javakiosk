package screengolfKiosk;

import java.util.Scanner;

public class FoodMenu extends Menu {
    public FoodMenu() {
        super("음식", new String[] {
                "컵라면: 신라면 / 짜파게티 / 김치왕뚜껑",
                "볶음밥: 김치볶음밥 / 계란볶음밥"
        });
    }
    public void selectOption(Scanner sc) {
        System.out.println("[음식 메뉴 션택 - " +getName()+"선택됨]");

        String[] friedriceOptions = {"김치볶음밥", "계란볶음밥"};
        int food1 = selectFromList(sc, "1. 음식 선택:", friedriceOptions);

        String[] ramenOptions = {"신라면", "짜파게티", "김치왕뚜껑"};
        int food2 = selectFromList(sc, "2. 음료 선택:", ramenOptions);

        System.out.println("\n입력하신 내용이 맞습니까?");
        System.out.println("- 음식: " + friedriceOptions[food1 - 1]);
        System.out.println("- 음료: " + ramenOptions[food2 - 1]);

        System.out.println("1. 네, 주문합니다");
        System.out.println("2. 아니요, 다시 선택할게요");
        int confirm = sc.nextInt();
        sc.nextLine();

        if (confirm == 2) {
            System.out.println("다시 선택을 시작합니다.\n");
            selectOption(sc);
        } else {
            System.out.println("주문이 완료되었습니다. 감사합니다!");
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
