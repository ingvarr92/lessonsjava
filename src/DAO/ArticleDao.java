package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static DAO.Main.sqlArticles;

public class ArticleDao extends MyConnection<Article> implements Dao<Article> {

    public ArticleDao() throws SQLException {
        getConnection();
        sqlExecute(sqlArticles);
    }

    @Override
    public void add(Article article) throws SQLException {
        sqlExecute(insertA, intParam(article.getId()), strParam(article.getTitle()), intParam(article.getIdUser()));


    }

    @Override
    public void delete(int i) throws SQLException {
        sqlExecute(deleteA, String.valueOf(i));
    }

    @Override
    public void update(int i, Article article) throws SQLException {
        sqlExecute(updateA, intParam(article.getId()), strParam(article.getTitle()), intParam(article.getIdUser()), intParam(article.getId()));
    }

    @Override
    public List<Article> getAll()  throws SQLException {
        ResultSet resultSet = sqlExecuteResult(getAll);

        List<Article> articles = new ArrayList<>();
        while (resultSet.next()) {
            articles.add(new Article(resultSet.getString("title"), resultSet.getInt("id_user")));
        }
        connectionClose();
        return articles;
    }

    @Override
    public Article getById(int id) throws SQLException {
        ResultSet resultSet = sqlExecuteResult(getById, intParam(id));
        resultSet.next();
        Article article = new Article(resultSet.getString("title"), resultSet.getInt("id_user"));
        connectionClose();
        return article;
    }
}
