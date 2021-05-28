public class Principal {
	
	public static void main(String[] args) {
		Screen.printGameHeader();
		
		boolean isRunning = true;
		
		String name = Teclado.leString("Digite o nome do seu Tamagochi: ");
		Tamagochi tamagochi =  new Tamagochi(name);
		
		while (tamagochi.isAlive() && isRunning == true) {
			System.out.println("=======================================");
			tamagochi.printStatus();
			tamagochi.printOptions();
			
			int option = Teclado.leInt("Digite sua ação: ");
			
			switch (option) {
			case 1:
				tamagochi.nextTurn(option);
				break;
			case 2:
				tamagochi.nextTurn(option);
				break;
			case 3:
				if (tamagochi.getState() == 1 || tamagochi.getState() == 3) {
					System.out.println("Opção invalida!");
				} else {
					tamagochi.nextTurn(option);	
				}
				break;
			case 0:
				isRunning = false;
				break;
			default:
				System.out.println("Opção invalida!");
				break;
			}
			
		}
		
		System.out.println("Obrigado por jogar,");
		System.out.println("Ricardo Martins Doberstein.");
	}
	
	
}
