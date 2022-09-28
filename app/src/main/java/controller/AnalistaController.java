/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import model.Analista;
import util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author ALAN
 */
public class AnalistaController {

    public void save(Analista analista) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        
        // comando de inserção sql
        String sql = "INSERT INTO analistas(IDANALISTA,"
                + "IDEQUIPE"
                + "NOME,"
                + "CARGO,"
                + "SALARIO)"
                + "VALUES (?,?,?,?,?)";

        try {
            // criar a conexao com o banco de dados
            connection = ConnectionFactory.getConnection("todoapp");
            
            // prepara a query sql
            statement = connection.prepareStatement(sql);
            
            // seta os valores dos respectivos campos
            statement.setInt(1, analista.getIdAnalista());
            statement.setInt(2, analista.getIdEquipe());
            statement.setString(3, analista.getNome());
            statement.setString(4, analista.getCargo());
            statement.setString(5, analista.getSalario());

            // executa o comando de inserção
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o analista " + e.getMessage(), e);
        } finally {
            // fecha a conexão
            ConnectionFactory.closeConnection(connection, statement);
            System.out.println("A conexão com o banco de dados foi fechada com sucesso");
        }
    }
}
