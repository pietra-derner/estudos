import java.util.Scanner;

public class MaquinaDeVendaAutomatica{
    private double valorAPagar = 0;
    Scanner scanner = new Scanner(System.in);
    int qtdeCafe, qtdePato, qtdeClips, qtdeTeclado;

    Produtos cafeExpresso = new Produtos("café expresso", 7.90, 50);
    Produtos patoDeBorracha = new Produtos("pato de borracha", 10.99, 200);
    Produtos clipsParaCabos = new Produtos("clips para cabos", 21.90, 35);
    Produtos tecladoMecanico = new Produtos("teclado mecânico", 329.90, 60);

    public void exibeMenu(){
        int opcao;
        System.out.printf("""
                Bem-vinda à Vending Machine Dev!
                Escolha a opção do produto que deseja comprar:
                1 - café expresso - R$%.2f
                2 - pato de borracha - R$%.2f
                3 - clips para cabos - R$%.2f
                4 - teclado mecânico - R$%.2f
                5 - finalizar compra
                0 - sair
                """, cafeExpresso.getPreco(), patoDeBorracha.getPreco(),
                clipsParaCabos.getPreco(), tecladoMecanico.getPreco());
        opcao = scanner.nextInt();

        while (opcao != 0){
            switch (opcao){
                case 1:
                    System.out.println("Boa escolha! Bora ficar acordado para codar!");
                    System.out.println("Quantos café você vai querer levar?");
                    qtdeCafe = scanner.nextInt();
                    if (qtdeCafe == 1){
                        System.out.println("Não tenho certeza que só um café será o suficiente! ¯|_(ツ)_/¯");
                    } else if (qtdeCafe > cafeExpresso.getQuantidadeProduto()) {
                        System.out.println("Sinto muito! Não temos tanto café assim!");
                        System.out.printf("""
                                Quantidade disponível: %d
                                E aí, quantos cafés você vai querer levar?
                                """, cafeExpresso.getQuantidadeProduto());
                        qtdeCafe = scanner.nextInt();
                    }
                    valorAPagar += (cafeExpresso.getPreco() * qtdeCafe);
                    System.out.printf("""
                            Você escolheu %d %s, totalizando R$%.2f!
                            """, qtdeCafe, cafeExpresso.getProduto(), (cafeExpresso.getPreco() * qtdeCafe));
                    break;
                case 2:
                    System.out.println("O pato sempre ajuda a resolver o bug!");
                    System.out.println("Quantos patinhos você vai querer levar?");
                    qtdePato = scanner.nextInt();
                    if (qtdePato > patoDeBorracha.getQuantidadeProduto()) {
                        System.out.println("Eita! Tem tanto bug pra tanto pato? Sinto muito, " +
                                "não temos tudo isso!");
                        System.out.printf("""
                                Quantidade disponível: %d
                                E aí, quantos patinhos você vai querer levar?
                                """, patoDeBorracha.getQuantidadeProduto());
                        qtdePato = scanner.nextInt();
                    }
                    valorAPagar += (patoDeBorracha.getPreco() * qtdePato);
                    System.out.printf("""
                            Você escolheu %d %s, totalizando R$%.2f!
                            """, qtdePato, patoDeBorracha.getProduto(), (patoDeBorracha.getPreco() * qtdePato));
                    break;
                case 3:
                    System.out.println("Bora organizar esse setup!");
                    System.out.println("Quantos clips você vai querer levar?");
                    qtdeClips = scanner.nextInt();
                    if (qtdeClips > clipsParaCabos.getQuantidadeProduto()) {
                        System.out.println("Não temos tudo isso de clips! :(");
                        System.out.printf("""
                                Quantidade disponível: %d
                                E aí, quantos clips você vai querer levar?
                                """, clipsParaCabos.getQuantidadeProduto());
                        qtdeClips = scanner.nextInt();
                    }
                    valorAPagar += (clipsParaCabos.getPreco() * qtdeClips);
                    System.out.printf("""
                            Você escolheu %d %s, totalizando R$%.2f!
                            """, qtdeClips, clipsParaCabos.getProduto(), (clipsParaCabos.getPreco() * qtdeClips));
                    break;
                case 4:
                    System.out.println("Deixando o setup bonitinho, hein?!");
                    System.out.println("Quantos teclados você vai querer levar?");
                    qtdeTeclado = scanner.nextInt();
                    if (qtdeTeclado > tecladoMecanico.getQuantidadeProduto()) {
                        System.out.println("Vou ficar te devendo! Não temos tudo isso de teclados! :(");
                        System.out.printf("""
                                Quantidade disponível: %d
                                E aí, quantos teclados você vai querer levar?
                                """, tecladoMecanico.getQuantidadeProduto());
                        qtdeTeclado = scanner.nextInt();
                    }
                    valorAPagar += (tecladoMecanico.getPreco() * qtdeTeclado);
                    System.out.printf("""
                            Você escolheu %d %s, totalizando R$%.2f!
                            """, qtdeTeclado, tecladoMecanico.getProduto(), (tecladoMecanico.getPreco() * qtdeTeclado));
                    break;
//                default:
//                    System.out.println("Opção inválida!");
//                    return;
            }
            System.out.println("""
                Escolha a opção do produto que deseja comprar:
                1 - café expresso
                2 - pato de borracha
                3 - clips para cabos
                4 - teclado mecânico
                5 - finalizar compra
                0 - sair
                    """);
            opcao = scanner.nextInt();
            switch (opcao){
                case 5:
                    System.out.println("Você comprou: " + qtdeCafe + " " + cafeExpresso.getProduto());
                    System.out.println(qtdePato + " " + patoDeBorracha.getProduto());
                    System.out.println(qtdeClips + " " + clipsParaCabos.getProduto());
                    System.out.println(qtdeTeclado + " " + tecladoMecanico.getProduto());
                    System.out.printf("Depois das suas compras, seu saldo ficou em: R$%.2f%n", valorAPagar);
                    System.out.println("""
                            Como deseja fazer o pagamento?
                            1 - dinheiro
                            2 - cartão de crédito/pix
                            """);
                    int formaDePagamento = scanner.nextInt();
                    if (formaDePagamento == 1){
                        System.out.println("Digite o valor em dinheiro para calcularmos o seu troco:");
                        double pagamento = scanner.nextDouble();
                        if (pagamento == valorAPagar){
                            System.out.println("Obrigada pela compra! Até mais!");
                            valorAPagar = 0;
                        } else if (pagamento < valorAPagar) {
                            System.out.println("Faltou R$" + (pagamento - valorAPagar) + "!");
                            return;
                        } else if (pagamento > valorAPagar) {
                            System.out.printf("Aqui está seu troco! R$%.2f%n", (pagamento - valorAPagar));
                            System.out.println("Obrigada pela compra. Até mais!");
                            valorAPagar = 0;
                        }
                    } else if (formaDePagamento == 2) {
                        System.out.println("Recebendo pagamento...");
                        System.out.println("Obrigada pela compra! Até mais!");
                        valorAPagar = 0;
                    }
                    break;
            }
        }
        System.out.println("Poxa, que pena que você saiu sem comprar! Te espero na próxima, dev! :)");
    }
}
