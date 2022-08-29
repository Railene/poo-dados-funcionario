package application;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Funcionario;




public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Funcionario> list = new ArrayList<>();
		
		// Dados da Leitura:
		
		System.out.print("Quantos funcionários serão cadastrados? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println();
			System.out.println("Funcionário #" + i + ": ");

			System.out.print("Id: ");
			int id = sc.nextInt();
			while (hasId(list, id)) {
				System.out.print("Id ja existe. Tente novamente: ");
				id = sc.nextInt();
			}
			
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salário: ");
			double salario = sc.nextDouble();
			list.add(new Funcionario(id, nome, salario));
		}

		// Atualização do salario de determinado funcionario:
		
		System.out.println();
		System.out.print("Digite o ID do Funcionário que terá aumento salarial: ");
		int id = sc.nextInt();
		Funcionario emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("Este ID não existe!");
		}
		else {
			System.out.print("Digite a porcentagem: ");
			double porcentagem = sc.nextDouble();
			emp.aumentarSalario(porcentagem);
		}
		
		// Funcionários da Lista:
		
		System.out.println();
		System.out.println("Lista de funcionário:");
		for (Funcionario obj : list) {
			System.out.println(obj);
		}
				
		sc.close(); 
	}
	
	public static boolean hasId(List<Funcionario> list, int id) {
		Funcionario emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}