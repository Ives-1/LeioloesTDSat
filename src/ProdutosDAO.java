/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosDAO {

    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public int cadastrarProduto(ProdutosDTO produto) {
        conn = new conectaDAO().connectDB();
        int status;
        try {
            prep = conn.prepareStatement("INSERT INTO produto VALUE (default, ?, ?, ?)");
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            return status = prep.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return e.getErrorCode();

        }
    }

    public ArrayList<ProdutosDTO> listarProdutos() {
        String sql = "SELECT * FROM produto";
        try {
            conn = new conectaDAO().connectDB();
            prep = conn.prepareStatement(sql);
            resultset = prep.executeQuery();

            while (resultset.next()) {
                ProdutosDTO pDTO = new ProdutosDTO();

                pDTO.setId(resultset.getInt("id"));
                pDTO.setNome(resultset.getString("nome"));
                pDTO.setValor(resultset.getInt("valor"));
                pDTO.setStatus(resultset.getString("status"));

                listagem.add(pDTO);
            }

        } catch (Exception e) {
        }
        return listagem;
    }
    
    public void venderProduto(int id){
        try {
            conn = new conectaDAO().connectDB();
            prep = conn.prepareStatement("UPDATE Produto SET status = ? WHERE id = ?");
            prep.setString(1, "Vendido");
            prep.setInt(2, id);
            prep.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar para vendido: " + e.getMessage());
        }
    }

}
