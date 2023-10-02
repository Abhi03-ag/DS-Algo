import java.util.*;
class Rings {
    public static int countPoints(String rings) {
        HashMap<Character, HashSet<Character>> count = new HashMap<Character, HashSet<Character>>();
        for (int i = 1; i < rings.length(); i = i + 2) {
            char towerNo = rings.charAt(i);
            char color = rings.charAt(i - 1);
            System.out.println(towerNo + "   " + color);
            if (!count.containsKey(towerNo)) {
                HashSet<Character> set = new HashSet<Character>();
                set.add(color);
                count.put(towerNo, set);
                count.entrySet().forEach(entry -> {
                    System.out.println("map " + entry.getKey() + " " + entry.getValue());
                });
            } else {
                System.out.println("Else block");
                HashSet<Character> set = count.get(Character.valueOf(towerNo));
                System.out.println(set);
                if (set.size() == 3)
                    return 1;
                else {
                    set.add(color);
                    count.put(towerNo, set);
                    count.entrySet().forEach(entry -> {
                        System.out.println("map " + entry.getKey() + " " + entry.getValue());
                    });
                    if (set.size() == 3)
                        return 1;

                }

            }
        }
        return 0;


    }
    public static void main(String args[]) {
        System.out.println(countPoints("B0B6G0R6R0R6G9"));
    }
}