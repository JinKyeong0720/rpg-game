package RPG_Game;

import java.util.ArrayList;

public class Shop {
	ArrayList<Item> itemList = new ArrayList<>();

	public Shop() {
		Item temp = new Item();
		temp.setKind(Item.getWeapon());
		temp.setName("검1");
		temp.setPower(3);
		temp.setPrice(1000);
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.getWeapon());
		temp.setName("검2");
		temp.setPower(5);
		temp.setPrice(2000);
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.getWeapon());
		temp.setName("검3");
		temp.setPower(7);
		temp.setPrice(2500);
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.getArmor());
		temp.setName("갑옷1");
		temp.setPower(1);
		temp.setPrice(300);
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.getArmor());
		temp.setName("갑옷2");
		temp.setPower(4);
		temp.setPrice(800);
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.getArmor());
		temp.setName("갑옷3");
		temp.setPower(7);
		temp.setPrice(1500);
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.getRing());
		temp.setName("반지1");
		temp.setPower(7);
		temp.setPrice(3000);
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.getRing());
		temp.setName("반지2");
		temp.setPower(17);
		temp.setPrice(6000);
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.getRing());
		temp.setName("반지3");
		temp.setPower(35);
		temp.setPrice(20000);
		itemList.add(temp);
	}

	public void shopMng() {
		while (true) {
			System.out.println("=============== [상점] ===============");
			System.out.println("[1.무기] [2.갑옷] [3.반지] [0.뒤로가기]");
			int selKind = MainGame.scan.nextInt();
			if (selKind == 0)
				return;
			while (true) {
				if (selKind == Item.getWeapon())
					System.out.println("=========== [무기] ============");
				else if (selKind == Item.getArmor())
					System.out.println("=========== [방어구] ============");
				else if (selKind == Item.getRing())
					System.out.println("=========== [반지] ============");
				printItems(selKind);
				System.out.println("[골드 : " + Player.getMoney() + "]");
				System.out.println("구입할 아이템 번호를 입력하세요 [0.뒤로가기]");
				int selNum = MainGame.scan.nextInt();
				if (selNum == 0)
					break;
				int count = 0;
				for (int i = 0; i < itemList.size(); i++) {
					if (itemList.get(i).getKind() == selKind) {
						count += 1;
						if (count == selNum) {
							Player.inven.addItem(itemList.get(i));
							Player.money -= itemList.get(i).getPrice();
							System.out.println("[" + itemList.get(i).getName() + "] 을 구입했습니다.");
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							break;
						}
					}
				}
			}
		}
	}

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}

	public void printItems(int kind) {
		int count = 0;
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getKind() != kind)
				continue;
			System.out.print("[" + (count + 1) + "번]");
			System.out.print("[이름 : " + itemList.get(i).getName() + "]");
			System.out.print("[능력 : " + itemList.get(i).getPower() + "]");
			System.out.print("[가격 : " + itemList.get(i).getPrice() + "]");
			System.out.println("");
			count += 1;
		}
	}
}