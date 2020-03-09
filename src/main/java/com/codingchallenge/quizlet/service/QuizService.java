package com.codingchallenge.quizlet.service;

import com.codingchallenge.quizlet.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Question getQuestion(String questionId) {
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("question_id_in", questionId);

        return jdbcTemplate.queryForObject("select * from get_question(?)",
                new Object[]{questionId}, (rs, rowNum) ->
                        new Question(rs.getString("question"),
                                rs.getString("question_id"),
                                rs.getString("answer_1"),
                                rs.getString("answer_2"),
                                rs.getString("answer_3"),
                                rs.getString("answer_4")));
    }

    public String getAnswer(String questionId, String answer) {
        String sql = "select * from get_answer(?,?)";

        return jdbcTemplate.queryForObject(
                sql, new Object[]{questionId, answer}, String.class);
    }

    public List<String> getAllQuestions() {

        return jdbcTemplate.query("select * from get_all_questions()",
                (rs, rowNum) -> new String(rs.getString("question_id")));

    }




}