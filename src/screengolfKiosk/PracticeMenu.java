package screengolfKiosk;

import java.util.Scanner;

public class PracticeMenu extends Menu {

    public PracticeMenu(String time) {
        super(time + "연습장", new String[] {
                "인원: 1명 / 2명 / 3명 / 4명",
                "방 선택: 1번 / 2번 / 3번 / 4번 / 5번",
                "하우스 채 대여: o / x",
                "장갑 대여: o / x",
                "옷 대여: o / x",
                "음료: 아이스커피 / 둥글레차 / 뜨거운 커피 / 아이스티 / 뜨거운 둥글레차"
        });
    }
    public void selectOption(Scanner sc) {
        System.out.println("["+ getName() + "] 선택됨");

        String[] peopleOption = {"1명","2명","3명","4명"};
        int people = showSelectMenu(sc, "1. 인원을 선택하세요: ", peopleOption);

        String[] roomOption = {"1번","2번","3번","4번"};
        int room = showSelectMenu(sc, "2. 방 번호를 선택하세요: ", roomOption);

        String house = getValidOX(sc, "3. 하우스 채 대여 (O/X): ");
        String gloves = getValidOX(sc, "4. 장갑 대여 (O/X): ");
        String cloth = getValidOX(sc, "5. 옷 대여 (O/X): ");

        String[] drinksOption = {"아이스커피","둥글레차","뜨거운 커피","아이스티", "뜨거운 둥글레차"};
        int drink = showSelectMenu(sc, "6. 음료를 선택하세요: ", drinksOption);

        System.out.println("\n입력하신 내용이 맞습니까?");
        System.out.println("- 인원: " + peopleOption[people - 1]);
        System.out.println("- 방 번호: " + roomOption[room - 1]);
        System.out.println("- 하우스채 대여: " + house);
        System.out.println("- 장갑 대여: " + gloves );
        System.out.println("- 음료: " + drinksOption[drink - 1]);

        System.out.println("1. 네 진행합니다.");
        System.out.println("2. 아니요, 다시 입력할게요.");
        int confirm = sc.nextInt();
        sc.nextLine();

        if(confirm == 2){
            System.out.println("다시 입력을 시작합니다. \n");
            selectOption(sc);
        } else {
            System.out.println("진행합니다. 감사합니다!");
        }
    }

    private int showSelectMenu(Scanner sc, String prompt, String[] options) {
        System.out.println(prompt);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        while (true) {
            System.out.println(">> ");
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                sc.nextLine();
                if (choice >= 1 && choice <= options.length) return choice;
                else sc.nextLine();
                System.out.println("잘못된 선택입니다. 다시 입력하세요.");
            }
        }
    }
    private String getValidOX(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().toUpperCase();  // 여기 소문자 → 대문자 변환
            if (input.equals("O") || input.equals("X")) {
                return input;
            }
            System.out.println("O 또는 X만 입력 가능합니다.");
        }
    }
}

