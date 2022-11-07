import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class Biblioteca {
    public static void main(String[] args) {
        ArrayList<Livro> livros = new ArrayList<>();
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

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Catalogo biblioteca");
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        int contador = 1;
        String contador_str = "1";

        data.put(contador_str, new Object[]{"Título do livro", "Autor", "Preco"});

        for(Livro livro: livros){
            contador++;
            data.put(String.valueOf(contador), new Object[]{livro.getNome(), livro.getAutor(), livro.getPreco()});
        }
        Set<String> keyset = data.keySet();
        int rownum = 0;

        for(String key: keyset){
            Row row = sheet.createRow(rownum++);
            Object[] objarr = data.get(key);
            int cellnum = 0;

            for(Object obj: objarr){
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String){
                    cell.setCellValue((String) obj);
                }
                else if (obj instanceof Integer){
                    cell.setCellValue((Integer) obj);
                }
                else if (obj instanceof Float){
                    cell.setCellValue((Float) obj);
                }
            }
        }
        try{
            FileOutputStream os = new FileOutputStream("teste.xlsx");
            workbook.write(os);
            System.out.println("OK");
            workbook.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
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