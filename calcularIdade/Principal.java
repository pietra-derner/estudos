package mes7julho2024.d19072024.calcularIdade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Digite sua data de nascimento:");
        String birth = scanner.nextLine();

        LocalDate birthFormatted = LocalDate.parse(birth, formatter);
        LocalDate today = LocalDate.now();

        System.out.println(birthFormatted);

        long years = ChronoUnit.YEARS.between(birthFormatted, today);
        System.out.println(years);
    }
}
