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

    public void cadastrarProduto(ProdutosDTO produto) {
        conn = new conectaDAO().connectDB();
        try {
            prep=conn.prepareStatement("INSERT INTO produto VALUES DEFAULT,?,?,?");
            prep.setString(0, produto.getNome());
            prep.setInt(1, produto.getValor());
            prep.setString(2, produto.getStatus());
            prep.execute();
            prep.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public ArrayList<ProdutosDTO> listarProdutos() {

        return listagem;
    }

}
