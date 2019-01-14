package DAO;

import java.sql.SQLException;

import static DAO.Main.sqlArticles;

public class ArticleDao extends MyConnection implements Dao<Article> {

    public ArticleDao() throws SQLException {
        getStatment().executeUpdate(sqlArticles);
    }

    @Override
    public void add(Article article) {
        try {
            getPStatment(insertA).setInt(1,article.getId());
            getPStatment(insertA).setString(2,article.getTitle());
            connectionClose();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int i) {

    }

//    @Override
//    public void update(int i, String s) {
//
//    }
//
//    @Override
//    public Article[] getAll() {
//        return new Article[];
//    }
//
//    @Override
//    public Article getById(int i) {
//        return Article;
//    }
}
