package RPG_Game;

import java.util.ArrayList;
import java.util.Scanner;

public class Guild {
	private static Scanner scan = new Scanner(System.in);
	private final int PARTY_SIZE = 4;
	private ArrayList<Unit> guildList = new ArrayList<>();
	private Unit[] partyList;

	public void setGuild() {
		Unit temp = new Unit("진경", 78, 150, 46, 53, 0);
		guildList.add(temp);
		temp = new Unit("도하", 1, 80, 7, 3, 0);
		guildList.add(temp);
		temp = new Unit("예지", 1, 50, 3, 1, 0);
		guildList.add(temp);
		temp = new Unit("세린", 1, 70, 5, 2, 0);
		guildList.add(temp);
		temp = new Unit("보석", 1, 200, 4, 8, 0);
		guildList.add(temp);
		temp = new Unit("지은", 1, 120, 11, 7, 0);
		guildList.add(temp);
		for (int i = 0; i < 4; i++) {
			guildList.get(i).setParty(true);
		}
		partyList = new Unit[PARTY_SIZE];
		int n = 0;
		for (int i = 0; i < guildList.size(); i++) {
			if (guildList.get(i).isParty() == true) {
				partyList[n] = guildList.get(i);
				n += 1;
			}
		}
	}

	public ArrayList<Unit> getGuildList() {
		return this.guildList;
	}
	
	public int getGuildListSize() {
		return this.partyList.length;
	}

	public void setGuildList(ArrayList<Unit> guildList) {
		this.guildList = guildList;
	}

	public Unit[] getPartyList() {
		return partyList;
	}

	public void setPartyList(Unit[] partyList) {
		this.partyList = partyList;
	}

	public int getPARTY_SIZE() {
		return PARTY_SIZE;
	}

	public Unit getGuildUnit(int num) {
		return guildList.get(num);
	}

	public void printAllUnitStaus() {
		System.out.println("======================================");
		System.out.println("[골드 : " + Player.getMoney() + "]");
		System.out.println("============== [길드원] ===============");
		System.out.println(this.getGuildList().size());
		for (int i = 0; i < guildList.size(); i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print(" [이름 : " + guildList.get(i).getName() + "]");
			System.out.print(" [레벨 : " + guildList.get(i).getLevel() + "]");
			System.out.print(" [체력 : " + guildList.get(i).getHp());
			System.out.println(" / " + guildList.get(i).getMaxHp() + "]");
			System.out.print("[공격력 : " + guildList.get(i).getAtt() + "]");
			System.out.print(" [방어력 : " + guildList.get(i).getDef() + "]");
			System.out.println(" [파티중 : " + guildList.get(i).isParty() + "]");
			System.out.println("");
		}
		System.out.println("======================================");
	}

	public void printUnitStaus(int num) {
		guildList.get(num).printStatus();
	}

	public void printUnitItem(int num) {
		guildList.get(num).printEquitedItem();
	}

	public void buyUnit() { // 길드 최대 인원 10명
		if (Player.money < 5000 || getGuildList().size() > 10)
			return;
		
		String[] n1 = { "고", "강", "김", "최", "윤", "정", "백" };
		String[] n2 = { "양", "이", "세", "민", "혜", "은", "예" };
		String[] n3 = { "이", "지", "현", "율", "진", "하", "정" };

		String name = n1[MainGame.ran.nextInt(n1.length)];
		name += n2[MainGame.ran.nextInt(n1.length)];
		name += n3[MainGame.ran.nextInt(n1.length)];
		int ran = MainGame.ran.nextInt(8) + 2;
		int hp = ran * 11;
		int att = ran + 1;
		int def = ran / 2 + 1;
		Unit temp = new Unit(name, 1, hp, att, def, 0);

		System.out.println("======================================");
		System.out.print("[이름 : " + name + "]");
		System.out.print(" [레벨 : " + 1 + "]");
		System.out.print(" [체력 : " + hp);
		System.out.println(" / " + hp + "]");
		System.out.print("[공격력 : " + att + "]");
		System.out.println(" [방어력 : " + def + "]");
		System.out.println("길드원을 추가합니다.");
		System.out.println("======================================");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		guildList.add(temp);
		Player.money -= 5000;
		
		
	}
	
	public void joinPartyFirst() {
		
	}

	public void removeUnit() {
		printAllUnitStaus();
		System.out.println("삭제할 번호를 입력하세요 ");
		int sel = MainGame.scan.nextInt();
		if (guildList.get(sel - 1).isParty()) {
			System.out.println("파티중인 멤버는 삭제할수 없습니다.");
		} else {
			System.out.println("======================================");
			System.out.print("[이름 : " + guildList.get(sel - 1).getName() + "]");
			System.out.println("길드원을 삭제합니다.");
			System.out.println("======================================");
			guildList.remove(sel - 1);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void arrayMember() { // 정렬

		while (true) {
			System.out.println("[1.이름] [2.공격력] [3.방어력]");
			System.out.println("[0.뒤로가기]");
			int sel = scan.nextInt();
			if (sel == 1) {
				arrayName();
			} else if (sel == 2) {
				arrayAtt();
			} else if (sel == 3) {
				arrayDef();
			} else if (sel == 0) {
				break;
			}
		}
	}
	
	// 정렬 !
//	private void sort() { // 이름순 정렬
//		for(int i=0; i<this.group.size(); i++) { // 인덱스 참조
//			Student a = this.group.get(i); // 인덱스번째 객체
//			String first = a.getName();
//			int index = i;
//			
//			for(int j=i; j<this.group.size(); j++) {
//				Student b = this.group.get(j);
//				
//				if(first.compareTo(b.getName()) > 0) { // first가 양수일 때 교체 가능
//					first = b.getName();
//					index = j;
//				}
//			}
//			
//			// 값(Student) 교체(교체대상은 Student 객체, this.group.array 안에 있음 -> setter 사용)
//			Student temp = this.group.get(i);// i번째 객체는 임시변수에 두기
//			this.group.set(i, this.group.get(index));
//			this.group.set(index, temp);
//		}
//	}
	

	public void arrayName() {
		for(int i=0; i<guildList.size(); i++) {
			Guild a = g
			
			for(int j=0; j<guildList.size(); j++) {
				
			}
		}
	}

	public void arrayAtt() {
		
	}
	
	public void arrayDef() {
		
	}	
	
	// 파티 인원 제한
	public void printParty() {
		System.out.println("================ [파티원] ===============");
		for (int i = 0; i < PARTY_SIZE; i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print(" [이름 : " + partyList[i].getName() + "]");
			System.out.print(" [레벨 : " + partyList[i].getLevel() + "]");
			System.out.print(" [체력 : " + partyList[i].getHp());
			System.out.println(" / " + partyList[i].getMaxHp() + "]");
			System.out.print("[공격력 : " + partyList[i].getAtt() + "]");
			System.out.print(" [방어력 : " + partyList[i].getDef() + "]");
			System.out.println(" [파티중 : " + guildList.get(i).isParty() + "]");
			System.out.println("");
		}
		System.out.println("======================================");
	}

	public void partyChange() {
		printParty();
		System.out.println("교체할 번호를 입력하세요 ");
		int partyNum = MainGame.scan.nextInt();
		printAllUnitStaus();
		System.out.println("참가할 번호를 입력하세요 ");
		int guildNum = MainGame.scan.nextInt();

		partyList[partyNum - 1].setParty(false);
		guildList.get(guildNum - 1).setParty(true);

		System.out.println("====================================");
		System.out.print("[이름 : " + partyList[partyNum - 1].getName() + "]");
		System.out.print("에서 ");
		System.out.print("[이름 : " + guildList.get(guildNum - 1).getName() + "]");
		System.out.println("으로 교체 합니다. ");
		System.out.println("====================================");

		int n = 0;
		for (int i = 0; i < guildList.size(); i++) {
			if (guildList.get(i).isParty()) {
				partyList[n] = guildList.get(i);
				n += 1;
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void partyDelete() {
		printParty();
		System.out.println("삭제할 번호를 입력하세요.");
		int partyNum = MainGame.scan.nextInt();
		
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	

	public void guildMenu() {
		while (true) {
			System.out.println("=========== [길드관리] ===========");
			System.out.println("[1.길드목록] [2.길드원추가] [3.길드원삭제]");
			System.out.println("[4.정렬] [5.파티원교체]  [6.파티원삭제]"); 
			System.out.println("[7.파티원추가] [8.]  [0.뒤로가기]"); 
			int sel = MainGame.scan.nextInt();
			if (sel == 1) {
				printAllUnitStaus();
			} else if (sel == 2) {
				buyUnit();
			} else if (sel == 3) {
				removeUnit();
			} else if (sel == 4) {
				arrayMember();
			} else if(sel == 5) {
				partyChange();
			} else if(sel == 6) {
				partyDelete();
			} else if (sel == 0) {
				break;
			}
		}
	}

}