import Model.Carta;
import Model.Pais;
import Model.Posicao;
import com.google.gson.Gson;
import spark.Spark;

import java.sql.SQLException;
import java.util.List;


public class Main {

    private static final Gson Gson = new Gson();

    public static void main(String[] args) throws SQLException {

// ############ DADOS DE TESTE ##############
//        Carta carta = new Carta();
//        Pais brasil = new Pais();
//
//        brasil.setNome("Brasil");
//
//        carta.setJogador("Vini Jr.");
//        carta.setRitmo(97);
//        carta.setPosicao(Posicao.PE);
//        carta.setDefesa(50);
//        carta.setPasse(85);
//        carta.setFinalizacao(87);
//        carta.setConducao(90);
//        carta.setPais(brasil);
//        carta.setEstrela(true);
//        carta.calculateOverall();
//
//        String cartaGson = Gson.toJson(carta);
//        Spark.get("/", (req, res) -> cartaGson);


     DAO cartasDAO = new DAO();

        List<Carta> cartas = cartasDAO.findAllCarta();

        String cartasGson = Gson.toJson(cartas);

     Spark.get("/", (req, res) -> cartasGson);

    }
}

