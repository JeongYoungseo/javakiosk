package screengolfKiosk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

       Menu[] gameMenu = {
               new GameMenu("18홀"),
               new GameMenu("9홀"),
               new GameMenu("포썸")
       };
       Menu[] practiceMenu = {
               new PracticeMenu("30분"),
               new PracticeMenu("1시간"),
               new PracticeMenu("1시간 30분"),
               new PracticeMenu("2시간")
       };

       Menu membershipMenu = new MembershipMenu();
       Menu foodMenu = new FoodMenu();

        System.out.println("==== 스크린골프 키오스크 ====");
        System.out.println("1. 게임 메뉴 보기");
        System.out.println("2. 연습장 메뉴 보기");
        System.out.println("3. 회원권 보기");
        System.out.println("4. 음식 보기");

        System.out.print("\n카테고리 번호를 선택하세요: ");
        int category = sc.nextInt();
        sc.nextLine();

        if (category == 1) {
            System.out.println("\n[게임메뉴]");
            for (int i = 0; i < gameMenu.length; i++) {
                System.out.println((i + 1) + ". " + gameMenu[i].getName());
            }
            System.out.print("메뉴 번호 선택: ");
            int sel = sc.nextInt();
            sc.nextLine();
            if (sel >= 1 && sel <= gameMenu.length) {
                ((GameMenu) gameMenu[sel - 1]).selectOption(sc);
            }
        } else if (category == 2) {
            System.out.println("\n[연습장 메뉴]");
            for (int i = 0; i < practiceMenu.length; i++) {
                System.out.println((i + 1) + ". " + practiceMenu[i].getName());
            }
            System.out.print("메뉴 번호 선택: ");
            int sel = sc.nextInt();
            sc.nextLine();
            if (sel >= 1 && sel <= practiceMenu.length) {
                ((PracticeMenu) practiceMenu[sel - 1]).selectOption(sc);
            }
        } else if (category == 3) {
            System.out.println("\n[회원권 선택]");
            ((MembershipMenu) membershipMenu).selectOptions(sc);
        } else if (category == 4) {
            System.out.println("[음식 선택]");
            ((FoodMenu) foodMenu).selectOption(sc);
        } else {
            System.out.println("잘못된 선택입니다.");
        }

        sc.close();
    }
}
