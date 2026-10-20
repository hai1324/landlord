package doudizhu;

import java.util.*;

public class LandlordGame {
    //分三阶段，备牌、洗牌、发牌
    static HashMap<Integer,String> map=new HashMap<>();
    //备牌
    static{
        int seq=1;
        String[] color={"♠","♥","♣","♦"};
        String[] num={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        for(String n : num) {
            for (String c:color) {
                map.put(seq, c + n);
                seq++;
            }
        }
        map.put(53,"小王");
        map.put(54,"大王");
    }
    public LandlordGame(){
        //洗牌
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 54; i++) {
            list.add(i);
        }
        Collections.shuffle(list);


        //发牌
        TreeSet<Integer> lord=new TreeSet<>();
        TreeSet<Integer> player1=new TreeSet<>();
        TreeSet<Integer> player2=new TreeSet<>();
        TreeSet<Integer> player3=new TreeSet<>();
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

    public ArrayList<String> lookCards(TreeSet<Integer> player){
        //看牌
        ArrayList<String> cards=new ArrayList<>();
        for (Integer i : player) {
            cards.add(map.get(i));
        }
        return cards;
    }

}
