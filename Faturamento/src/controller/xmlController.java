package controller;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class xmlController {
    private List<DiaValor> getXML() {
        //Transformando xml em lista
        List<DiaValor> diaValores = new ArrayList<>();
        try {

            File file = new File("./src/dados(2).xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            Element root = document.getDocumentElement();
            NodeList rows = root.getElementsByTagName("row");


            for (int i = 0; i < rows.getLength(); i++) {
                Element element = (Element) rows.item(i);
                Element diaEle = (Element) element.getElementsByTagName("dia").item(0);
                Element valorEle = (Element) element.getElementsByTagName("valor").item(0);

                int dia = Integer.parseInt(diaEle.getTextContent());
                double valor = Double.parseDouble(valorEle.getTextContent());

                DiaValor diaValor = new DiaValor(dia, valor);
                diaValores.add(diaValor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return diaValores;
    }

    public void valores(){
        List<DiaValor> listaDias =  getXML();
        listaDias.sort(Comparator.comparingDouble(DiaValor::getValor));

        //Remover finais de semana e feriados
        listaDias.removeIf(diaValor -> diaValor.getValor() == 0);

        double mediaMensal = 0;
        for(DiaValor diaValor : listaDias){
            mediaMensal += diaValor.getValor();
        }
        mediaMensal /= listaDias.size(); //media

        //Maiores e menores
        int menorDia = listaDias.getFirst().getDia();
        double menorValor = listaDias.getFirst().getValor();

        int maiorDia = listaDias.getLast().getDia();
        double maiorValor = listaDias.getLast().getValor();

        int cont = 0;
        for(DiaValor diaValor : listaDias){
            if(diaValor.getValor() > mediaMensal){
                cont++;
            }
        }

        System.out.println("Menor valor de faturamento: " + menorValor + "\nDia: " + menorDia);
        System.out.println("\nMaior valor de faturamento: " + maiorValor + "\nDia: " + maiorDia);
        System.out.println("\nDias acima da média: " + cont);

    }
}
