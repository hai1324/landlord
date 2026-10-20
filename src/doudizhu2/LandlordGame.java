package doudizhu2;

import java.util.*;

public class LandlordGame {
    //分三阶段，备牌、洗牌、发牌
    static HashMap<String,Integer> map=new HashMap<>();
    static ArrayList<String> list=new ArrayList<>();
    //备牌
    static{
        String[] color={"♠","♥","♣","♦"};
        String[] num={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        for (String c : color) {
            for (String n : num) {
                list.add(c+n);
            }
        }
        list.add(" 小王");
        list.add(" 大王");
        map.put("J",11);
        map.put("Q",12);
        map.put("K",13);
        map.put("A",14);
        map.put("2",15);
        map.put("小王",53);
        map.put("大王",54);
    }
    public LandlordGame(){
        //洗牌
        Collections.shuffle(list);

        //发牌
        ArrayList<String> lord=new ArrayList<>();
        ArrayList<String> player1=new ArrayList<>();
        ArrayList<String> player2=new ArrayList<>();
        ArrayList<String> player3=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(i<=2){
                lord.add(list.get(i));
                continue;
            }
            if(i%3==0){
                player1.add(list.get(i));
            }else if(i%3==1){
                player2.add(list.get(i));
            }else{
                player3.add(list.get(i));
            }
        }
        System.out.println("lord = " + lookCards(lord));
        System.out.println("player1 = " + lookCards(player1));
        System.out.println("player2 = " + lookCards(player2));
        System.out.println("player3 = " + lookCards(player3));
    }


    public ArrayList<String> lookCards(ArrayList<String> player){
        //看牌
        ArrayList<String> cards=player;
        cards.sort((o1, o2) -> {
            String c1 = o1.substring(0, 1);
            String n1 = o1.substring(1);
            String c2 = o2.substring(0, 1);
            String n2 = o2.substring(1);
            int i = map.containsKey(n1) ? map.get(n1) : Integer.parseInt(n1);
            int j = map.containsKey(n2) ? map.get(n2) : Integer.parseInt(n2);
            if (i == j) {
                return c1.compareTo(c2);
            }
            return i - j;
        });
        return cards;
    }

}
