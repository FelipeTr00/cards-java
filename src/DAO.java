import Model.Carta;
import Model.Pais;
import Model.Posicao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private Connection conn;

    public DAO() {
        this.conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/cards_java",
                    "root",
                    "123"
            );
            System.out.println("Conexão com o banco de dados estabelecida com sucesso.");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver MySQL não encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o banco MySQL.");
            e.printStackTrace();
        }
    }

    public List<Carta> findAllCarta() throws SQLException {
        List<Carta> cartas = new ArrayList<>();
        String sql = "SELECT * FROM carta;";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Carta carta = new Carta();

                carta.setConducao(rs.getInt("conducao"));
                carta.setDefesa(rs.getInt("defesa"));
                carta.setFinalizacao(rs.getInt("finalizacao"));
                carta.setRitmo(rs.getInt("ritmo"));
                carta.setPasse(rs.getInt("passes"));
                carta.setPosicao(Posicao.valueOf(rs.getString("posicao")));
                carta.setPais(findPaisById(rs.getInt("id_nacionalidade")));
                carta.setPosicoesSecundarias(findPosicoesSecundarias(carta));
                carta.calculateOverall();

                cartas.add(carta);
            }
            System.out.println("Cartas encontradas: " + cartas.size());

        } catch (SQLException e) {
            System.err.println("Falha ao consultar cartas.");
            e.printStackTrace();
        }

        return cartas;
    }

    public Pais findPaisById(int id) {
        Pais pais = new Pais();
        String sql = "SELECT * FROM pais WHERE id = ?;";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pais.setNome(rs.getString("nome"));
                    pais.setUrlImagem(rs.getString("url_imagem"));
                } else {
                    System.out.println("País não encontrado para o ID: " + id);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao consultar o país.");
            e.printStackTrace();
        }
        return pais;
    }

    public List<Posicao> findPosicoesSecundarias(Carta carta) {
        List<Posicao> posicoes = new ArrayList<>();

        String sql = "SELECT * FROM posicao_jogador WHERE id_jogador = ?;";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, carta.getId());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    posicoes.add(Posicao.valueOf(rs.getString("ds_posicao")));
                }
                System.out.println("Posições secundárias encontradas: " + posicoes.size());
            }
        } catch (SQLException e) {
            System.err.println("Falha ao consultar posições secundárias.");
            e.printStackTrace();
        }

        return posicoes;
    }
}
