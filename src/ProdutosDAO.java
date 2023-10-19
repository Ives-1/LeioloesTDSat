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

        return listagem;
    }

}
