package org.ict.bodychecker.retrofit;

import org.ict.bodychecker.ValueObject.ExerciseVO;
import org.ict.bodychecker.ValueObject.GoalVO;
import org.ict.bodychecker.ValueObject.MealVO;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface RetrofitInterface {

    /*================== Exercise ====================*/
    @GET("exer/{edate}.json")
    Call<List<ExerciseVO>> getDailyExer(@Path("edate") String edate);

    @GET("exer/neweno")
    Call<Integer> getNewEno();

    @POST("exer/new")
    Call<ExerciseVO> registerExer(@Body ExerciseVO exer);

    @PUT("exer/modify/{eno}")
    Call<ExerciseVO> modifyExer(@Path("eno") int eno, @Body ExerciseVO exer);

    @DELETE("exer/remove/{eno}")
    Call<Void> removeExer(@Path("eno") int eno);

    /*================== Goal ====================*/
    @GET("goal/doing/{fin_date}.json")
    Call<List<GoalVO>> getDoing(@Path("fin_date") String fin_date);

    @GET("goal/newgno.json")
    Call<Integer> getNewGno();

    @POST("goal/new")
    Call<GoalVO> registerGoal(@Body GoalVO goal);

    /*================== Meal ====================*/
    @GET("meal/getList/{fdate}.json")
    Call<List<MealVO>> getDailyMeal(@Path("fdate") String fdate);

    @POST("meal/addFoods")
    Call<MealVO> addFoods(@Body MealVO mealVo);

    @DELETE("meal/remove/{fdate}/{ftime}")
    Call<Void> removeFoods(@Path("fdate") String fdate, @Path("ftime") String ftime);
}
