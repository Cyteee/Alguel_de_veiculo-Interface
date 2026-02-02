import model.entities.AluguelDeCarro;
import model.entities.Veiculo;

void main() {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm)");

    System.out.println("Entre com os dados do aluguel: ");
    System.out.print("Modelo do carro: ");
    String modeloDoCarro = sc.nextLine();
    System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
    LocalDateTime comeco = LocalDateTime.parse(sc.nextLine(), fmt);
    System.out.print("Devolucao (dd/MM/yyyy hh:mm): ");
    LocalDateTime fim = LocalDateTime.parse(sc.nextLine(), fmt);

    AluguelDeCarro ac = new AluguelDeCarro(comeco, fim, new Veiculo(modeloDoCarro));



    sc.close();
}