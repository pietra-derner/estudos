import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JogoForca {
    private String palavraSecreta;
    Scanner scanner = new Scanner(System.in);

    public void jogar(){
        System.out.println("""
                ______
                |   |
                |  ( )    Bem-vindo/a ao
                |  -:-        jogo da
                |  / |     F  O  R  C  A
                |
                ¨¨
                1 | Começar um novo jogo com frutas
                2 | Começar um novo jogo com profissões
                3 | Começar um novo jogo com cores
                0 | Sair
                """);
        int opcao = scanner.nextInt();
        scanner.nextLine();

        while (opcao != 0){
            switch (opcao){
                case 1:
                    forcaComFrutas();
                    break;
                case 2:
                    forcaComProfissoes();
                    break;
                case 3:
                    forcaComCores();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            System.out.println("""
                1 | Começar um novo jogo com frutas
                2 | Começar um novo jogo com profissões
                3 | Começar um novo jogo com cores
                0 | Sair
                """);
            opcao = scanner.nextInt();
            scanner.nextLine();
        }
    }

    public void forcaComFrutas(){
        List<String> listaFrutas = new ArrayList<>();
        listaFrutas.add("uva");
        listaFrutas.add("amora");
        listaFrutas.add("banana");
        listaFrutas.add("kiwi");
        listaFrutas.add("morango");

        Random random = new Random();
        palavraSecreta = listaFrutas.get(random.nextInt(listaFrutas.size())).toUpperCase();

        jogo();
    }

    public void forcaComProfissoes(){
        List<String> listaProfissoes = new ArrayList<>();
        listaProfissoes.add("programadora");
        listaProfissoes.add("dentista");
        listaProfissoes.add("pintora");
        listaProfissoes.add("escritora");
        listaProfissoes.add("zeladora");

        Random random = new Random();
        palavraSecreta = listaProfissoes.get(random.nextInt(listaProfissoes.size())).toUpperCase();

        jogo();
    }

    public void forcaComCores(){
        List<String> listaCores = new ArrayList<>();
        listaCores.add("azul");
        listaCores.add("cinza");
        listaCores.add("amarelo");
        listaCores.add("preto");
        listaCores.add("fucsia");

        Random random = new Random();
        palavraSecreta = listaCores.get(random.nextInt(listaCores.size())).toUpperCase();

        jogo();
    }

    public void jogo(){
        List<String> qtdeCaracteres = new ArrayList<>();

        System.out.println("A palavra secreta tem " + palavraSecreta.length() + " letras!");
        for (int i = 0; i < palavraSecreta.length(); i++){
            qtdeCaracteres.add("_");
        }
        System.out.println(qtdeCaracteres);

        int qtdeTentativas = 5;
        System.out.println("Você tem 5 tentativas!");
        while (qtdeTentativas > 0){
            if(qtdeTentativas <= 2){
                System.out.println("Gostaria de tentar um chute? (S/N)");
                String opcao = scanner.nextLine();
                if (opcao.equalsIgnoreCase("s")){
                    System.out.println("Digite o seu chute:");
                    String chute = scanner.nextLine();
                    if (chute.equalsIgnoreCase(palavraSecreta)){
                        System.out.println("Parabéns, você ganhou o jogo!");
                        return;
                    } else {
                        System.out.println("A palavra secreta não é essa! :(");
                    }
                }
            }
            System.out.println("Digite uma letra:");
            String letra = scanner.nextLine().toUpperCase();
            if (palavraSecreta.contains(letra)){
                for (int i = 0; i < palavraSecreta.length(); i++){
                    if (palavraSecreta.charAt(i) == letra.charAt(0)){
                        qtdeCaracteres.set(i, letra);
                    }
                }
                System.out.println(qtdeCaracteres);
                if (!qtdeCaracteres.contains("_")){
                    System.out.println("Parabéns, você acertou a palavra!");
                    break;
                }
            } else {
                System.out.println("Não existe essa letra na palavra secreta!");
            }
            qtdeTentativas--;
            System.out.println("Você tem mais " + qtdeTentativas + " chances para acertar!");
        }
        if (qtdeCaracteres.contains("_")){
            System.out.println("Que pena! Não foi dessa vez. A palavra secreta era: " + palavraSecreta);
        }
    }
}