import java.util.Random;

public class Tamagochi {
	private String name;
	private int age;
	private int weight;
	private boolean alive;
	private int state = 0;
	
	private int daysWithoutSleep = 0;
	private boolean eatenTooMuch = false;
	private boolean isHungry = false;
	
	private Random random = new Random();
	
	Tamagochi(String name) {
		this.name = name;
		this.age = 0;
		this.weight = 1;
		this.alive = true;
		
		this.state = this.random.nextInt((3 - 1) + 1) + 1;
	}
	
	public void printStatus() {
		System.out.println(this.name);
		System.out.println("Idade: " + this.age + " dias    Peso: " + this.weight + " kg");
		System.out.println("");	
		
		switch (this.state) {
		case 1:
			System.out.println(this.name + " Esta com sono.");	
			break;
		case 2:
			System.out.println(this.name + " Esta com fome.");
			break;
		case 3:
			System.out.println(this.name + " Esta entediado.");
			break;
		}
		
		System.out.println("");	
	}
	
	public void printOptions() {
		switch (this.state) {
		case 1:
			System.out.println("1 - Dormir.");
			System.out.println("2 - Permanescer Acordado.");
			System.out.println("0 - Sair do Jogo.");
			break;
		case 2:
			System.out.println("1 - Comer muito.");
			System.out.println("2 - Comer pouco.");
			System.out.println("3 - Não comer.");
			System.out.println("0 - Sair do Jogo.");
			break;
		case 3:
			System.out.println("1 - Correr 10 minutos");
			System.out.println("2 - Caminhar 10 minutos");
			System.out.println("0 - Sair do Jogo.");
			break;
		}
	}
	
	public void nextTurn(int action) {
		switch (this.state) {
		case 1:
			this.sleep(action);
			break;
		case 2:
			this.eat(action);
			break;
		case 3:
			this.exercise(action);
			break;
		}
		
		this.state = this.random.nextInt((3 - 1) + 1) + 1;
	}
	
	private void sleep(int action) {
		if (action == 1) {
			this.age += 1;
			this.daysWithoutSleep = 0;
		} else {
			this.daysWithoutSleep += 1;
		}
	}
	
	private void eat(int action) {
		if (action == 1) {
			this.weight += 5;
		} else if (action == 2) {
			this.weight += 1;
		} else {
			this.weight -= 2;
		}
	}
	
	private void exercise(int action) {
		if (action == 1) {
			this.weight -= 4;
			
			// TO CONFIRM: After exercising too much, is the creature go and eat alot by itself?
			this.eat(2);
		} else {
			this.weight -= 1;
			this.isHungry = true;
		}
	}
	
	public int getState() {
		return this.state;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public boolean isAlive() {
		return this.alive;
	}
}
