package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    try {
        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkin = sdf.parse(sc.next()); //converte a string para o sdf e depois o armazena na variável formatada
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkout = sdf.parse(sc.next());

        Reservation reservation = new Reservation(number, checkin, checkout);
        System.out.println("Reservation: " + reservation);

        System.out.println();
        System.out.println("Enter data to update the reservation: ");
        System.out.print("Check-in date (dd/MM/yyyy): ");
        checkin = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        checkout = sdf.parse(sc.next());

        reservation.updateDates(checkin, checkout);
        System.out.println("Reservation: " + reservation);
    }
    catch (ParseException e) {
        System.out.println("Invalid date format");
    } //tratando dados inválidos previstos
    catch (DomainException e) {
        System.out.println("Error in reservation: " + e.getMessage());
    } //exceção lançada por algum erro na entidade de domínio, ou seja, Reservation
    catch (RuntimeException e) {
        System.out.println("Unexpected error");
    } //utilizando uma estrutura genérica para tratar qualquer exceção runtime

    sc.close();

    }
}
