import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите данные: ");
        String input = s.nextLine();
        String output = calc(input);
        if (output == null){System.out.println("Неверный формат");}
        else {System.out.println(output);}
    }

    public static String calc(String input){

        int i1, i2, r = 0;
        boolean roms = false;
        String[] words = input.split(" ");
        if (words.length != 3) {
            return null;
        }
        String num1, num2;
        num1 = words[0];
        num2 = words[2];

        boolean pr = registr(num1, num2);
        if (!pr) {
            return null; }
        roms = ro(num1,num2);
        if (roms) {i1 = rom1(num1);
                   i2 = rom2(num2);}
        else {i1 = Integer.parseInt(num1);
              i2 = Integer.parseInt(num2);}
        if (i1 > 10 || i1 <0 || i2 > 10 || i2 < 0){
            return null;}
        String plus = "+", minus = "-", umn = "*", del = "/";
        if (input.contains(plus)) {
            r = i1 + i2;
        } else if (input.contains(minus)){
            r = i1 - i2;
        } else if (input.contains(umn)){
            r = i1 * i2;
        } else if (input.contains(del)){
            if (i2 == 0){System.out.println("На ноль делить нельзя");
                return null;}
            r = i1 / i2;
        } else {
            return null;
        }
        if (roms && r < 0) {
            return null;}
        if (roms && r > 0){
            return toRom(r);}
        return Integer.toString(r);
    }

    private static boolean registr(String num1, String num2) {
        String rom = "IIIVIIIX";
        String ar = "12345678910";
        if ((rom.contains(num1) && rom.contains(num2)) || (ar.contains(num1) && ar.contains(num2)) ){
            return true;}
        else{
            return false;
        }
    }

    private static boolean ro(String num1, String num2) {
        String rom = "IIIVIIIX";
        if (rom.contains(num1) && rom.contains(num2)){
            return true;}
        else{
            return false;
        }
    }
    private static int rom1(String num1){
        String[] roma = {"0","I","II","III","IV","V","VI","VII","VIII","IX","X"};
        int i1 = -1;
        for (int i = 0; i< roma.length; i++){
            if (roma[i].equals(num1)){
                i1 = i;}
            }
        return i1;
    }
    private static int rom2(String num2){
        String[] roma = {"0","I","II","III","IV","V","VI","VII","VIII","IX","X"};
        int i2 = -1;
        for (int i = 0; i< roma.length; i++){
            if (roma[i].equals(num2)){
                i2 = i;}
        }
        return i2;
    }
    private static String toRom(int r){
        String k;
        String [] Romes = {"0","I", "II", "III", "IV", "V", "VI","VII","VIII","IX","X","XI","XII","XIII","XIV","XV","XVI",
                "XVII","XVIII","XIX","XX","XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX","XXXI",
                "XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL","XLI","XLII","XLIII","XLIV","XLV",
                "XLVI","XLVII","XLVIII","XLIX","L","LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX","LX","LXI","LXII",
                "LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX","LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI",
                "LXXVII","LXXVIII","LXXIX","LXXX","LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII",
                "LXXXIX","XC","XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C"};
        k = Romes[r];
        return k;

    }

}
