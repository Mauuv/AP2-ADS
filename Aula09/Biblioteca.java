import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {
        ArrayList<Livro> livros = new ArrayList<>();

        try{
            File f = new File("biblioteca.bin");
            if (f.exists()){
                try (FileInputStream fis = new FileInputStream(f);
                     ObjectInputStream ois = new ObjectInputStream(fis)){
                    livros = (ArrayList<Livro>) ois.readObject();
                    System.out.println("Dados lidos: ");
                    for (Livro livro: livros) {
                        System.out.print(livro.toString()
                        + System.lineSeparator());
                    }
                } catch (ClassNotFoundException ex){
                    System.err.println("Erro ao ler o arquivo");
                }
            }
        } catch(IOException e) {
            System.err.println("Erro ao abrir arquivo");
        }

        int opcao;
        Livro livroTempAlt, livroTempDel;

        do {
            mostraMenu();
            opcao = escolheOpcao(1,5);
            switch (opcao){
                case 1:
                    livros.add(criaLivro());
                    break;
                case 2:
                    livroTempDel = achaLivro(livros);
                    if (livros.remove(livroTempDel)
                    && livroTempDel != null) {
                        System.out.println("Livro removido com sucesso");
                    } else {
                        System.err.println("Não foi achado, tente novamente");
                    }
                    break;
                case 3:
                    livroTempAlt = achaLivro(livros);
                    livros.set(livros.indexOf(livroTempAlt), criaLivro());
                    break;
                case 4:
                    for(Livro livro : livros){
                        System.out.println(livro.toString());
                    }
            }
        } while(opcao!=5);

        try{
            File f = new File("biblioteca.bin");
            if (!f.exists()){
                f.createNewFile();
            }
            try(FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(livros);
            }
            System.out.println("Dados salvos com sucesso: ");
            for (Livro livro: livros) {
                System.out.print(livro.toString()
                + System.lineSeparator());
            }
        } catch(IOException e){
            System.err.println("Erro ao criar arquivo .bin");
        }
    }

    public static void mostraMenu(){
        System.out.println("=-=-=- Biblioteca RuyBarbosa -=-=-="
                + System.lineSeparator() + "1 - Cadastrar livro"
                + System.lineSeparator() + "2 - Deletar livro"
                + System.lineSeparator() + "3 - Modificar cadastro de livro"
                + System.lineSeparator() + "4 - Listar acervo"
                + System.lineSeparator() + "5 - Encerrar a execução");
    }

    public static Livro criaLivro(){
        Scanner in = new Scanner(System.in);
        String nome = null, editora = null, autor = null;
        float preco = 0;
        int ano = 0;

        try {
            System.out.println("Qual é o nome do livro");
            nome = in.nextLine();

            System.out.println("Quem é o autor do livro?");
            autor = in.nextLine();

            System.out.println("Qual editora publicou o livro");
            editora = in.nextLine();

            System.out.println("Quando o livro foi publicado");
            ano = in.nextInt();

            System.out.println("Qual será o preço do livro");
            preco = in.nextFloat();
        } catch (InputMismatchException e){
            System.err.println("Erro, tipo incompativel, refaça o cadastro");
            criaLivro();
        }

        return new Livro(autor, editora, ano, nome, preco);
    }

    private static Livro achaLivro(ArrayList<Livro> livros) {
        Scanner in = new Scanner(System.in);
        String nomeLivro, nomeAutor;

        System.out.println("Qual livro você deseja excluir");
        nomeLivro = in.nextLine();

        System.out.println("Quem é o autor desse livro?");
        nomeAutor = in.nextLine();

        Livro temp = new Livro(nomeLivro, nomeAutor);

        if(livros.contains(temp)){
            return temp;
        }
        return null;
    }

    public static int escolheOpcao(int min, int max) {
        Scanner in = new Scanner(System.in);
        int opcao = 0;
        try {
            opcao = in.nextInt();
        } catch (InputMismatchException e){
            System.err.println("Erro, tipo incompátivel");
            escolheOpcao(min, max);
        }
        if (opcao < min
                || opcao > max) {
            System.err.println("ERRO. Opcão invalida");
            escolheOpcao(min, max);
        }
        return opcao;
    }


}