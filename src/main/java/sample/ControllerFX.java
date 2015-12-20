package sample;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerFX {

    private Stage guiRoot;
    private final String DB_LOGIN = "root";
    private final String DB_PASSWORD = "0000";
    private final String DB_SCHEMA_NAME = "univer";
    private Connection DB_CONNECTION = null;

    private String Query;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="EDDel"
    private AnchorPane EDDel; // Value injected by FXMLLoader

    @FXML // fx:id="direction_upd"
    private TextField direction_upd; // Value injected by FXMLLoader

    @FXML // fx:id="nameGroup_del"
    private TextField nameGroup_del; // Value injected by FXMLLoader

    @FXML // fx:id="tab_del"
    private Tab tab_del; // Value injected by FXMLLoader

    @FXML // fx:id="nameCathedraCath"
    private TextField nameCathedraCath; // Value injected by FXMLLoader

    @FXML // fx:id="FacultyDel"
    private AnchorPane FacultyDel; // Value injected by FXMLLoader

    @FXML // fx:id="nameCathedraTeach_upd"
    private TextField nameCathedraTeach_upd; // Value injected by FXMLLoader

    @FXML // fx:id="lastNameStudent"
    private TextField lastNameStudent; // Value injected by FXMLLoader

    @FXML // fx:id="numberRecordBook"
    private TextField numberRecordBook; // Value injected by FXMLLoader

    @FXML // fx:id="tab_upd"
    private Tab tab_upd; // Value injected by FXMLLoader

    @FXML // fx:id="NumberED_upd"
    private TextField NumberED_upd; // Value injected by FXMLLoader

    @FXML // fx:id="CathedraAdd"
    private AnchorPane CathedraAdd; // Value injected by FXMLLoader

    @FXML // fx:id="nameFacultyFac_upd"
    private TextField nameFacultyFac_upd; // Value injected by FXMLLoader

    @FXML // fx:id="TG1"
    private ToggleGroup TG1; // Value injected by FXMLLoader

    @FXML // fx:id="Teacher_update"
    private Group Teacher_update; // Value injected by FXMLLoader

    @FXML // fx:id="Student_del"
    private Group Student_del; // Value injected by FXMLLoader

    @FXML // fx:id="personalNumberTeacher_upd"
    private TextField personalNumberTeacher_upd; // Value injected by FXMLLoader

    @FXML // fx:id="nameCathedra_del"
    private TextField nameCathedra_del; // Value injected by FXMLLoader

    @FXML // fx:id="Techer_del"
    private Group Techer_del; // Value injected by FXMLLoader

    @FXML // fx:id="lastNameStudent_upd"
    private TextField lastNameStudent_upd; // Value injected by FXMLLoader

    @FXML // fx:id="phone"
    private TextField phone; // Value injected by FXMLLoader

    @FXML // fx:id="Faculty_del"
    private Group Faculty_del; // Value injected by FXMLLoader

    @FXML // fx:id="nameCathedraTeach"
    private TextField nameCathedraTeach; // Value injected by FXMLLoader

    @FXML // fx:id="nameGroupStuGro_upd"
    private TextField nameGroupStuGro_upd; // Value injected by FXMLLoader

    @FXML // fx:id="dean"
    private TextField dean; // Value injected by FXMLLoader

    @FXML // fx:id="yearBirth"
    private TextField yearBirth; // Value injected by FXMLLoader

    @FXML // fx:id="TeacherDel"
    private AnchorPane TeacherDel; // Value injected by FXMLLoader

    @FXML // fx:id="Cathedra_update"
    private Group Cathedra_update; // Value injected by FXMLLoader

    @FXML // fx:id="addressEB_upd"
    private TextField addressEB_upd; // Value injected by FXMLLoader

    @FXML // fx:id="studentsGroup_rb"
    private RadioButton studentsGroup_rb; // Value injected by FXMLLoader

    @FXML // fx:id="StudentsGroupDel"
    private AnchorPane StudentsGroupDel; // Value injected by FXMLLoader

    @FXML // fx:id="headDepartment_upd"
    private TextField headDepartment_upd; // Value injected by FXMLLoader

    @FXML // fx:id="yearBirth_upd"
    private TextField yearBirth_upd; // Value injected by FXMLLoader

    @FXML // fx:id="dean_upd"
    private TextField dean_upd; // Value injected by FXMLLoader

    @FXML // fx:id="numberEDCath"
    private TextField numberEDCath; // Value injected by FXMLLoader

    @FXML // fx:id="phoneDean"
    private TextField phoneDean; // Value injected by FXMLLoader

    @FXML // fx:id="nameCourse"
    private TextField nameCourse; // Value injected by FXMLLoader

    @FXML // fx:id="nameFacultuStuGro_upd"
    private TextField nameFacultuStuGro_upd; // Value injected by FXMLLoader

    @FXML // fx:id="nameFacultuStuGro"
    private TextField nameFacultuStuGro; // Value injected by FXMLLoader

    @FXML // fx:id="testButton"
    private Button testButton; // Value injected by FXMLLoader

    @FXML // fx:id="StudentUpdate"
    private AnchorPane StudentUpdate; // Value injected by FXMLLoader

    @FXML // fx:id="EDAdd"
    private AnchorPane EDAdd; // Value injected by FXMLLoader

    @FXML // fx:id="FacultyUpdate"
    private AnchorPane FacultyUpdate; // Value injected by FXMLLoader

    @FXML // fx:id="teacher_rb"
    private RadioButton teacher_rb; // Value injected by FXMLLoader

    @FXML // fx:id="CathedraDel"
    private AnchorPane CathedraDel; // Value injected by FXMLLoader

    @FXML // fx:id="StudentsGroup_update"
    private Group StudentsGroup_update; // Value injected by FXMLLoader

    @FXML // fx:id="EDUpdate"
    private AnchorPane EDUpdate; // Value injected by FXMLLoader

    @FXML // fx:id="phone_upd"
    private TextField phone_upd; // Value injected by FXMLLoader

    @FXML // fx:id="personalNumberTeacher"
    private TextField personalNumberTeacher; // Value injected by FXMLLoader

    @FXML // fx:id="jobTittle"
    private TextField jobTittle; // Value injected by FXMLLoader

    @FXML // fx:id="Faculty_update"
    private Group Faculty_update; // Value injected by FXMLLoader

    @FXML // fx:id="numberStudents"
    private TextField numberStudents; // Value injected by FXMLLoader

    @FXML // fx:id="Faculty_add"
    private Group Faculty_add; // Value injected by FXMLLoader

    @FXML // fx:id="headDepartment"
    private TextField headDepartment; // Value injected by FXMLLoader

    @FXML // fx:id="pane_del"
    private AnchorPane pane_del; // Value injected by FXMLLoader

    @FXML // fx:id="StudentsGroupUpdate"
    private AnchorPane StudentsGroupUpdate; // Value injected by FXMLLoader

    @FXML // fx:id="FacultyAdd"
    private AnchorPane FacultyAdd; // Value injected by FXMLLoader

    @FXML // fx:id="faculty_rb"
    private RadioButton faculty_rb; // Value injected by FXMLLoader

    @FXML // fx:id="phoneDisp_upd"
    private TextField phoneDisp_upd; // Value injected by FXMLLoader

    @FXML // fx:id="phoneDisp"
    private TextField phoneDisp; // Value injected by FXMLLoader

    @FXML // fx:id="personalNumberTeach_del"
    private TextField personalNumberTeach_del; // Value injected by FXMLLoader

    @FXML // fx:id="jobTittle_upd"
    private TextField jobTittle_upd; // Value injected by FXMLLoader

    @FXML // fx:id="TeacherUpdate"
    private AnchorPane TeacherUpdate; // Value injected by FXMLLoader

    @FXML // fx:id="tab_add"
    private Tab tab_add; // Value injected by FXMLLoader

    @FXML // fx:id="add"
    private Button add; // Value injected by FXMLLoader

    @FXML // fx:id="NumberED"
    private TextField NumberED; // Value injected by FXMLLoader

    @FXML // fx:id="ED_add"
    private Group ED_add; // Value injected by FXMLLoader

    @FXML // fx:id="degree"
    private TextField degree; // Value injected by FXMLLoader

    @FXML // fx:id="nameGroupStu"
    private TextField nameGroupStu; // Value injected by FXMLLoader

    @FXML // fx:id="phoneDepartment_upd"
    private TextField phoneDepartment_upd; // Value injected by FXMLLoader

    @FXML // fx:id="numberED_del"
    private TextField numberED_del; // Value injected by FXMLLoader

    @FXML // fx:id="nameGroupStu_upd"
    private TextField nameGroupStu_upd; // Value injected by FXMLLoader

    @FXML // fx:id="nameCathedraCath_upd"
    private TextField nameCathedraCath_upd; // Value injected by FXMLLoader

    @FXML // fx:id="addressEB"
    private TextField addressEB; // Value injected by FXMLLoader

    @FXML // fx:id="phoneDepartment"
    private TextField phoneDepartment; // Value injected by FXMLLoader

    @FXML // fx:id="StudentDel"
    private AnchorPane StudentDel; // Value injected by FXMLLoader

    @FXML // fx:id="lastNameTeacher"
    private TextField lastNameTeacher; // Value injected by FXMLLoader

    @FXML // fx:id="Student_add"
    private Group Student_add; // Value injected by FXMLLoader

    @FXML // fx:id="StudentsGroup_del"
    private Group StudentsGroup_del; // Value injected by FXMLLoader

    @FXML // fx:id="nameCathedraStuGro"
    private TextField nameCathedraStuGro; // Value injected by FXMLLoader

    @FXML // fx:id="cathedra_rb"
    private RadioButton cathedra_rb; // Value injected by FXMLLoader

    @FXML // fx:id="Cathedra_del"
    private Group Cathedra_del; // Value injected by FXMLLoader

    @FXML // fx:id="StudentAdd"
    private AnchorPane StudentAdd; // Value injected by FXMLLoader

    @FXML // fx:id="student_rb"
    private RadioButton student_rb; // Value injected by FXMLLoader

    @FXML // fx:id="ED_del"
    private Group ED_del; // Value injected by FXMLLoader

    @FXML // fx:id="StudentsGroup_add"
    private Group StudentsGroup_add; // Value injected by FXMLLoader

    @FXML // fx:id="nameGroupStuGrou"
    private TextField nameGroupStuGrou; // Value injected by FXMLLoader

    @FXML // fx:id="nameCathedraStuGro_upd"
    private TextField nameCathedraStuGro_upd; // Value injected by FXMLLoader

    @FXML // fx:id="update"
    private Button update; // Value injected by FXMLLoader

    @FXML // fx:id="Student_update"
    private Group Student_update; // Value injected by FXMLLoader

    @FXML // fx:id="delete"
    private Button delete; // Value injected by FXMLLoader

    @FXML // fx:id="TeacherAdd"
    private AnchorPane TeacherAdd; // Value injected by FXMLLoader

    @FXML // fx:id="StudentsGroupAdd"
    private AnchorPane StudentsGroupAdd; // Value injected by FXMLLoader

    @FXML // fx:id="degree_upd"
    private TextField degree_upd; // Value injected by FXMLLoader

    @FXML // fx:id="ED_update"
    private Group ED_update; // Value injected by FXMLLoader

    @FXML // fx:id="CathedraUpdate"
    private AnchorPane CathedraUpdate; // Value injected by FXMLLoader

    @FXML // fx:id="numberRecordBook_upd"
    private TextField numberRecordBook_upd; // Value injected by FXMLLoader

    @FXML // fx:id="direction"
    private TextField direction; // Value injected by FXMLLoader

    @FXML // fx:id="lastNameTeacher_upd"
    private TextField lastNameTeacher_upd; // Value injected by FXMLLoader

    @FXML // fx:id="nameFacultyFac"
    private TextField nameFacultyFac; // Value injected by FXMLLoader

    @FXML // fx:id="numberStudents_upd"
    private TextField numberStudents_upd; // Value injected by FXMLLoader

    @FXML // fx:id="nameCourse_upd"
    private TextField nameCourse_upd; // Value injected by FXMLLoader

    @FXML // fx:id="addressTeach_upd"
    private TextField addressTeach_upd; // Value injected by FXMLLoader

    @FXML // fx:id="nameFaculty_del"
    private TextField nameFaculty_del; // Value injected by FXMLLoader

    @FXML // fx:id="numberEDCath_upd"
    private TextField numberEDCath_upd; // Value injected by FXMLLoader

    @FXML // fx:id="EB_rb"
    private RadioButton EB_rb; // Value injected by FXMLLoader

    @FXML // fx:id="phoneDean_upd"
    private TextField phoneDean_upd; // Value injected by FXMLLoader

    @FXML // fx:id="numberRecordBook_del"
    private TextField numberRecordBook_del; // Value injected by FXMLLoader

    @FXML // fx:id="tab_view"
    private Tab tab_view; // Value injected by FXMLLoader

    @FXML // fx:id="Teacher_add"
    private Group Teacher_add; // Value injected by FXMLLoader

    @FXML // fx:id="addressTeach"
    private TextField addressTeach; // Value injected by FXMLLoader

    @FXML // fx:id="mainTableView"
    private TableView<?> mainTableView; // Value injected by FXMLLoader

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert EDDel != null : "fx:id=\"EDDel\" was not injected: check your FXML file 'sample.fxml'.";
        assert direction_upd != null : "fx:id=\"direction_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameGroup_del != null : "fx:id=\"nameGroup_del\" was not injected: check your FXML file 'sample.fxml'.";
        assert tab_del != null : "fx:id=\"tab_del\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameCathedraCath != null : "fx:id=\"nameCathedraCath\" was not injected: check your FXML file 'sample.fxml'.";
        assert FacultyDel != null : "fx:id=\"FacultyDel\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameCathedraTeach_upd != null : "fx:id=\"nameCathedraTeach_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert lastNameStudent != null : "fx:id=\"lastNameStudent\" was not injected: check your FXML file 'sample.fxml'.";
        assert numberRecordBook != null : "fx:id=\"numberRecordBook\" was not injected: check your FXML file 'sample.fxml'.";
        assert tab_upd != null : "fx:id=\"tab_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert NumberED_upd != null : "fx:id=\"NumberED_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert CathedraAdd != null : "fx:id=\"CathedraAdd\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameFacultyFac_upd != null : "fx:id=\"nameFacultyFac_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert TG1 != null : "fx:id=\"TG1\" was not injected: check your FXML file 'sample.fxml'.";
        assert Teacher_update != null : "fx:id=\"Teacher_update\" was not injected: check your FXML file 'sample.fxml'.";
        assert Student_del != null : "fx:id=\"Student_del\" was not injected: check your FXML file 'sample.fxml'.";
        assert personalNumberTeacher_upd != null : "fx:id=\"personalNumberTeacher_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameCathedra_del != null : "fx:id=\"nameCathedra_del\" was not injected: check your FXML file 'sample.fxml'.";
        assert Techer_del != null : "fx:id=\"Techer_del\" was not injected: check your FXML file 'sample.fxml'.";
        assert lastNameStudent_upd != null : "fx:id=\"lastNameStudent_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert phone != null : "fx:id=\"phone\" was not injected: check your FXML file 'sample.fxml'.";
        assert Faculty_del != null : "fx:id=\"Faculty_del\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameCathedraTeach != null : "fx:id=\"nameCathedraTeach\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameGroupStuGro_upd != null : "fx:id=\"nameGroupStuGro_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert dean != null : "fx:id=\"dean\" was not injected: check your FXML file 'sample.fxml'.";
        assert yearBirth != null : "fx:id=\"yearBirth\" was not injected: check your FXML file 'sample.fxml'.";
        assert TeacherDel != null : "fx:id=\"TeacherDel\" was not injected: check your FXML file 'sample.fxml'.";
        assert Cathedra_update != null : "fx:id=\"Cathedra_update\" was not injected: check your FXML file 'sample.fxml'.";
        assert addressEB_upd != null : "fx:id=\"addressEB_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert studentsGroup_rb != null : "fx:id=\"studentsGroup_rb\" was not injected: check your FXML file 'sample.fxml'.";
        assert StudentsGroupDel != null : "fx:id=\"StudentsGroupDel\" was not injected: check your FXML file 'sample.fxml'.";
        assert headDepartment_upd != null : "fx:id=\"headDepartment_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert yearBirth_upd != null : "fx:id=\"yearBirth_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert dean_upd != null : "fx:id=\"dean_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert numberEDCath != null : "fx:id=\"numberEDCath\" was not injected: check your FXML file 'sample.fxml'.";
        assert phoneDean != null : "fx:id=\"phoneDean\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameCourse != null : "fx:id=\"nameCourse\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameFacultuStuGro_upd != null : "fx:id=\"nameFacultuStuGro_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameFacultuStuGro != null : "fx:id=\"nameFacultuStuGro\" was not injected: check your FXML file 'sample.fxml'.";
        assert testButton != null : "fx:id=\"testButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert StudentUpdate != null : "fx:id=\"StudentUpdate\" was not injected: check your FXML file 'sample.fxml'.";
        assert EDAdd != null : "fx:id=\"EDAdd\" was not injected: check your FXML file 'sample.fxml'.";
        assert FacultyUpdate != null : "fx:id=\"FacultyUpdate\" was not injected: check your FXML file 'sample.fxml'.";
        assert teacher_rb != null : "fx:id=\"teacher_rb\" was not injected: check your FXML file 'sample.fxml'.";
        assert CathedraDel != null : "fx:id=\"CathedraDel\" was not injected: check your FXML file 'sample.fxml'.";
        assert StudentsGroup_update != null : "fx:id=\"StudentsGroup_update\" was not injected: check your FXML file 'sample.fxml'.";
        assert EDUpdate != null : "fx:id=\"EDUpdate\" was not injected: check your FXML file 'sample.fxml'.";
        assert phone_upd != null : "fx:id=\"phone_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert personalNumberTeacher != null : "fx:id=\"personalNumberTeacher\" was not injected: check your FXML file 'sample.fxml'.";
        assert jobTittle != null : "fx:id=\"jobTittle\" was not injected: check your FXML file 'sample.fxml'.";
        assert Faculty_update != null : "fx:id=\"Faculty_update\" was not injected: check your FXML file 'sample.fxml'.";
        assert numberStudents != null : "fx:id=\"numberStudents\" was not injected: check your FXML file 'sample.fxml'.";
        assert Faculty_add != null : "fx:id=\"Faculty_add\" was not injected: check your FXML file 'sample.fxml'.";
        assert headDepartment != null : "fx:id=\"headDepartment\" was not injected: check your FXML file 'sample.fxml'.";
        assert pane_del != null : "fx:id=\"pane_del\" was not injected: check your FXML file 'sample.fxml'.";
        assert StudentsGroupUpdate != null : "fx:id=\"StudentsGroupUpdate\" was not injected: check your FXML file 'sample.fxml'.";
        assert FacultyAdd != null : "fx:id=\"FacultyAdd\" was not injected: check your FXML file 'sample.fxml'.";
        assert faculty_rb != null : "fx:id=\"faculty_rb\" was not injected: check your FXML file 'sample.fxml'.";
        assert phoneDisp_upd != null : "fx:id=\"phoneDisp_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert phoneDisp != null : "fx:id=\"phoneDisp\" was not injected: check your FXML file 'sample.fxml'.";
        assert personalNumberTeach_del != null : "fx:id=\"personalNumberTeach_del\" was not injected: check your FXML file 'sample.fxml'.";
        assert jobTittle_upd != null : "fx:id=\"jobTittle_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert TeacherUpdate != null : "fx:id=\"TeacherUpdate\" was not injected: check your FXML file 'sample.fxml'.";
        assert tab_add != null : "fx:id=\"tab_add\" was not injected: check your FXML file 'sample.fxml'.";
        assert add != null : "fx:id=\"add\" was not injected: check your FXML file 'sample.fxml'.";
        assert NumberED != null : "fx:id=\"NumberED\" was not injected: check your FXML file 'sample.fxml'.";
        assert ED_add != null : "fx:id=\"ED_add\" was not injected: check your FXML file 'sample.fxml'.";
        assert degree != null : "fx:id=\"degree\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameGroupStu != null : "fx:id=\"nameGroupStu\" was not injected: check your FXML file 'sample.fxml'.";
        assert phoneDepartment_upd != null : "fx:id=\"phoneDepartment_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert numberED_del != null : "fx:id=\"numberED_del\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameGroupStu_upd != null : "fx:id=\"nameGroupStu_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameCathedraCath_upd != null : "fx:id=\"nameCathedraCath_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert addressEB != null : "fx:id=\"addressEB\" was not injected: check your FXML file 'sample.fxml'.";
        assert phoneDepartment != null : "fx:id=\"phoneDepartment\" was not injected: check your FXML file 'sample.fxml'.";
        assert StudentDel != null : "fx:id=\"StudentDel\" was not injected: check your FXML file 'sample.fxml'.";
        assert lastNameTeacher != null : "fx:id=\"lastNameTeacher\" was not injected: check your FXML file 'sample.fxml'.";
        assert Student_add != null : "fx:id=\"Student_add\" was not injected: check your FXML file 'sample.fxml'.";
        assert StudentsGroup_del != null : "fx:id=\"StudentsGroup_del\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameCathedraStuGro != null : "fx:id=\"nameCathedraStuGro\" was not injected: check your FXML file 'sample.fxml'.";
        assert cathedra_rb != null : "fx:id=\"cathedra_rb\" was not injected: check your FXML file 'sample.fxml'.";
        assert Cathedra_del != null : "fx:id=\"Cathedra_del\" was not injected: check your FXML file 'sample.fxml'.";
        assert StudentAdd != null : "fx:id=\"StudentAdd\" was not injected: check your FXML file 'sample.fxml'.";
        assert student_rb != null : "fx:id=\"student_rb\" was not injected: check your FXML file 'sample.fxml'.";
        assert ED_del != null : "fx:id=\"ED_del\" was not injected: check your FXML file 'sample.fxml'.";
        assert StudentsGroup_add != null : "fx:id=\"StudentsGroup_add\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameGroupStuGrou != null : "fx:id=\"nameGroupStuGrou\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameCathedraStuGro_upd != null : "fx:id=\"nameCathedraStuGro_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert update != null : "fx:id=\"update\" was not injected: check your FXML file 'sample.fxml'.";
        assert Student_update != null : "fx:id=\"Student_update\" was not injected: check your FXML file 'sample.fxml'.";
        assert delete != null : "fx:id=\"delete\" was not injected: check your FXML file 'sample.fxml'.";
        assert TeacherAdd != null : "fx:id=\"TeacherAdd\" was not injected: check your FXML file 'sample.fxml'.";
        assert StudentsGroupAdd != null : "fx:id=\"StudentsGroupAdd\" was not injected: check your FXML file 'sample.fxml'.";
        assert degree_upd != null : "fx:id=\"degree_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert ED_update != null : "fx:id=\"ED_update\" was not injected: check your FXML file 'sample.fxml'.";
        assert CathedraUpdate != null : "fx:id=\"CathedraUpdate\" was not injected: check your FXML file 'sample.fxml'.";
        assert numberRecordBook_upd != null : "fx:id=\"numberRecordBook_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert direction != null : "fx:id=\"direction\" was not injected: check your FXML file 'sample.fxml'.";
        assert lastNameTeacher_upd != null : "fx:id=\"lastNameTeacher_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameFacultyFac != null : "fx:id=\"nameFacultyFac\" was not injected: check your FXML file 'sample.fxml'.";
        assert numberStudents_upd != null : "fx:id=\"numberStudents_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameCourse_upd != null : "fx:id=\"nameCourse_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert addressTeach_upd != null : "fx:id=\"addressTeach_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameFaculty_del != null : "fx:id=\"nameFaculty_del\" was not injected: check your FXML file 'sample.fxml'.";
        assert numberEDCath_upd != null : "fx:id=\"numberEDCath_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert EB_rb != null : "fx:id=\"EB_rb\" was not injected: check your FXML file 'sample.fxml'.";
        assert phoneDean_upd != null : "fx:id=\"phoneDean_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert numberRecordBook_del != null : "fx:id=\"numberRecordBook_del\" was not injected: check your FXML file 'sample.fxml'.";
        assert tab_view != null : "fx:id=\"tab_view\" was not injected: check your FXML file 'sample.fxml'.";
        assert Teacher_add != null : "fx:id=\"Teacher_add\" was not injected: check your FXML file 'sample.fxml'.";
        assert addressTeach != null : "fx:id=\"addressTeach\" was not injected: check your FXML file 'sample.fxml'.";
        assert mainTableView != null : "fx:id=\"mainTableView\" was not injected: check your FXML file 'sample.fxml'.";

        testButton.setOnAction(event -> {
            System.out.println("Button was pressed!");

            try {
                DB_CONNECTION = getConnection();

                if (DB_CONNECTION != null)
                    System.out.println("Got a connection!");

                System.out.println();

                ResultSet test2 = getResultFromDB(
                        SQLQueryType.SELECT,
                        "cathedra",
                        "head_of_department",
                        getSQLString("Vahidov")
                );

                while (test2.next()) {
                    System.out.println(test2.getString(2));
                }

                ResultSet testAdd1 = getResultFromDB(
                        SQLQueryType.INSERT,
                        "cathedra",
                        "TestCathedra1",
                        "TestHeadOfDepartment",
                        "4368236",
                        "6"
                );

                ResultSet test = getResultFromDB(
                        SQLQueryType.SELECT,
                        "cathedra"
                );

                while (test.next()) {
                    System.out.println(test.getString(1));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            cathedra_rb.setOnAction(event1 -> {
                EDAdd.setVisible(false);
                StudentAdd.setVisible(false);
                StudentsGroupAdd.setVisible(false);
                TeacherAdd.setVisible(false);
                FacultyAdd.setVisible(false);
                CathedraAdd.setVisible(true);

                EDDel.setVisible(false);
                StudentDel.setVisible(false);
                StudentsGroupDel.setVisible(false);
                TeacherDel.setVisible(false);
                FacultyDel.setVisible(false);
                CathedraDel.setVisible(true);

                EDUpdate.setVisible(false);
                StudentUpdate.setVisible(false);
                StudentsGroupUpdate.setVisible(false);
                TeacherUpdate.setVisible(false);
                FacultyUpdate.setVisible(false);
                CathedraUpdate.setVisible(true);

                //если нажата кнопка добавить запись то вызываем функцию с определенным типом запроса для опред талицы
                add.setOnAction(event2 -> {

                   AddToDatabase(SQLTable.CATHEDRA, SQLQueryType.INSERT);
                });
                delete.setOnAction(event2 -> {
                    DeleteFromDatabase(SQLTable.CATHEDRA, SQLQueryType.DELETE);
                });
                update.setOnAction(event2 -> {
                    UpdateDatabase(SQLTable.CATHEDRA, SQLQueryType.UPDATE);
                });

            });

            student_rb.setOnAction(event1 -> {
                EDAdd.setVisible(false);
                StudentAdd.setVisible(true);
                StudentsGroupAdd.setVisible(false);
                TeacherAdd.setVisible(false);
                FacultyAdd.setVisible(false);
                CathedraAdd.setVisible(false);

                EDDel.setVisible(false);
                StudentDel.setVisible(true);
                StudentsGroupDel.setVisible(false);
                TeacherDel.setVisible(false);
                FacultyDel.setVisible(false);
                CathedraDel.setVisible(false);

                EDUpdate.setVisible(false);
                StudentUpdate.setVisible(true);
                StudentsGroupUpdate.setVisible(false);
                TeacherUpdate.setVisible(false);
                FacultyUpdate.setVisible(false);
                CathedraUpdate.setVisible(false);

                add.setOnAction(event2 -> {
                    AddToDatabase(SQLTable.STUDENT, SQLQueryType.INSERT);
                });
                delete.setOnAction(event2 -> {
                    DeleteFromDatabase(SQLTable.STUDENT, SQLQueryType.DELETE);
                });
                update.setOnAction(event2 -> {
                    UpdateDatabase(SQLTable.STUDENT, SQLQueryType.UPDATE);
                });
            });

            faculty_rb.setOnAction(event1 -> {
                EDAdd.setVisible(false);
                StudentAdd.setVisible(false);
                StudentsGroupAdd.setVisible(false);
                TeacherAdd.setVisible(false);
                FacultyAdd.setVisible(true);
                CathedraAdd.setVisible(false);

                EDDel.setVisible(false);
                StudentDel.setVisible(false);
                StudentsGroupDel.setVisible(false);
                TeacherDel.setVisible(false);
                FacultyDel.setVisible(true);
                CathedraDel.setVisible(false);

                EDUpdate.setVisible(false);
                StudentUpdate.setVisible(false);
                StudentsGroupUpdate.setVisible(false);
                TeacherUpdate.setVisible(false);
                FacultyUpdate.setVisible(true);
                CathedraUpdate.setVisible(false);

                add.setOnAction(event2 -> {
                    AddToDatabase(SQLTable.FACULTY, SQLQueryType.INSERT);
                });
                delete.setOnAction(event2 -> {
                    DeleteFromDatabase(SQLTable.FACULTY, SQLQueryType.DELETE);
                });
                update.setOnAction(event2 -> {
                    UpdateDatabase(SQLTable.FACULTY, SQLQueryType.UPDATE);
                });
            });

            studentsGroup_rb.setOnAction(event1 -> {
                EDAdd.setVisible(false);
                StudentAdd.setVisible(false);
                StudentsGroupAdd.setVisible(true);
                TeacherAdd.setVisible(false);
                FacultyAdd.setVisible(false);
                CathedraAdd.setVisible(false);

                EDDel.setVisible(false);
                StudentDel.setVisible(false);
                StudentsGroupDel.setVisible(true);
                TeacherDel.setVisible(false);
                FacultyDel.setVisible(false);
                CathedraDel.setVisible(false);

                EDUpdate.setVisible(false);
                StudentUpdate.setVisible(false);
                StudentsGroupUpdate.setVisible(true);
                TeacherUpdate.setVisible(false);
                FacultyUpdate.setVisible(false);
                CathedraUpdate.setVisible(false);

                add.setOnAction(event2 -> {
                    AddToDatabase(SQLTable.GROUP, SQLQueryType.INSERT);
                });
                delete.setOnAction(event2 -> {
                    DeleteFromDatabase(SQLTable.GROUP, SQLQueryType.DELETE);
                });
                update.setOnAction(event2 -> {
                    UpdateDatabase(SQLTable.GROUP, SQLQueryType.UPDATE);
                });
            });

            teacher_rb.setOnAction(event1 -> {
                EDAdd.setVisible(false);
                StudentAdd.setVisible(false);
                StudentsGroupAdd.setVisible(false);
                TeacherAdd.setVisible(true);
                FacultyAdd.setVisible(false);
                CathedraAdd.setVisible(false);

                EDDel.setVisible(false);
                StudentDel.setVisible(false);
                StudentsGroupDel.setVisible(false);
                TeacherDel.setVisible(true);
                FacultyDel.setVisible(false);
                CathedraDel.setVisible(false);

                EDUpdate.setVisible(false);
                StudentUpdate.setVisible(false);
                StudentsGroupUpdate.setVisible(false);
                TeacherUpdate.setVisible(true);
                FacultyUpdate.setVisible(false);
                CathedraUpdate.setVisible(false);

                add.setOnAction(event2 -> {
                    AddToDatabase(SQLTable.TEACHER, SQLQueryType.INSERT);
                });
                delete.setOnAction(event2 -> {
                    DeleteFromDatabase(SQLTable.TEACHER, SQLQueryType.DELETE);
                });
                update.setOnAction(event2 -> {
                    UpdateDatabase(SQLTable.TEACHER, SQLQueryType.UPDATE);
                });
            });

            EB_rb.setOnAction(event1 -> {
                EDAdd.setVisible(true);
                StudentAdd.setVisible(false);
                StudentsGroupAdd.setVisible(false);
                TeacherAdd.setVisible(false);
                FacultyAdd.setVisible(false);
                CathedraAdd.setVisible(false);

                EDDel.setVisible(true);
                StudentDel.setVisible(false);
                StudentsGroupDel.setVisible(false);
                TeacherDel.setVisible(false);
                FacultyDel.setVisible(false);
                CathedraDel.setVisible(false);

                EDUpdate.setVisible(true);
                StudentUpdate.setVisible(false);
                StudentsGroupUpdate.setVisible(false);
                TeacherUpdate.setVisible(false);
                FacultyUpdate.setVisible(false);
                CathedraUpdate.setVisible(false);

                add.setOnAction(event2 -> {

                    AddToDatabase(SQLTable.BUILDING, SQLQueryType.INSERT);
                });
                delete.setOnAction(event2 -> {
                    DeleteFromDatabase(SQLTable.BUILDING, SQLQueryType.DELETE);
                });
                update.setOnAction(event2 -> {
                    UpdateDatabase(SQLTable.BUILDING, SQLQueryType.UPDATE);
                });
            });

        });
    }

    @FXML
    private Button selectTable;

    public void setStage(Stage source) {
        this.guiRoot = source;
    }

    private void AddToDatabase(SQLTable table, SQLQueryType query) {
        System.out.println("table " + table.toString() + " query " + query.toString());


    }

    private void DeleteFromDatabase(SQLTable table, SQLQueryType query) {
        System.out.println("table " + table.toString() + " query " + query.toString());


    }

    private void UpdateDatabase(SQLTable table, SQLQueryType query) {
        System.out.println("table " + table.toString() + " query " + query.toString());


    }

    /*
    * Транзакция - это комплексная операция, состоящая из группы операций, которые выполняются либо все,
    * либо ни одной в случае ошибки или отмены.
    *
    * Каждое действие с БД - транзакция.
    * Транзакция завершается только после вызова метода commit (если в начале работы с базой было вызвано setAutoCommit(false)).
    * */

    public void stopController() throws SQLException {
        if (DB_CONNECTION != null) {
            DB_CONNECTION.close();
        }
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_SCHEMA_NAME +
                "?user=" + DB_LOGIN + "&password=" + DB_PASSWORD);
    }

    private String getSQLString(String source) {
        if (source == null) return source;

        return '\'' + source + '\'';
    }

    private long getLongValue(String source) throws ParseException {
        return Long.parseLong(source);
    }

    private String getVarchar255Arg(String source, String keyState) throws IllegalArgumentException {
        if (source == null) {
            throw new IllegalArgumentException("String was not initialized");
        } else if (source.isEmpty() && keyState.equals("YES")) {
            throw new IllegalArgumentException("Invalid primary key");
        } else if (source.trim().length() > 255) {
            throw new IllegalArgumentException("String size limit was overexceeded");
        } else if (source.toUpperCase().contains("DROP") || source.toUpperCase().contains("DELETE")) {
            throw new IllegalArgumentException("Don't be so smart, meh.");
        }

        return source.trim();
    }

    private long getInt11Arg(String source, String keyState) throws Exception {
        if (source == null) {
            throw new IllegalArgumentException("String was not initialized");
        } else if (source.isEmpty() && keyState.equals("YES")) {
            throw new IllegalArgumentException("Invalid primary key");
        } else if (source.trim().length() > 11) {
            throw new IllegalArgumentException("String size limit was overexceeded");
        }

        return getLongValue(source.trim());
    }

    private ArrayList<SQLTableColumnsInfo> getColumnsData(String tableName) throws Exception {
        ArrayList<SQLTableColumnsInfo> result = new ArrayList<>();

        Statement columnsGetter = DB_CONNECTION.createStatement();
        ResultSet columnsData = columnsGetter.executeQuery("SHOW COLUMNS FROM " + DB_SCHEMA_NAME + "." + tableName);
        while (columnsData.next()) {
            result.add(new SQLTableColumnsInfo(columnsData.getString(1), columnsData.getString(2), columnsData.getString(3)));
        }

        return result;
    }

    private ResultSet getResultFromDB(SQLQueryType type, String... args) throws Exception {
        ResultSet result = null;

        switch (type) {
            case SELECT: {
                // SELECT columns FROM table WHERE conditions;
                // conditions => column_name = value
                if (args.length == 0) {
                    throw new SQLException("No arguments were provided for SELECT statement.");
                } else if (args.length % 2 == 0 || args.length > 3) {
                    throw new SQLException("Invalid number of arguments for SELECT statement.");
                } else {
                    Statement statement = DB_CONNECTION.createStatement();

                    if (args.length == 1) {
                        result = statement.executeQuery("SELECT * FROM " + DB_SCHEMA_NAME + '.' + args[0]);
                    } else {
                        result = statement.executeQuery("SELECT * FROM " + DB_SCHEMA_NAME + '.' + args[0]
                                + " WHERE " + args[1] + " = " + args[2]);
                    }
                }
                break;
            }
            case INSERT: {
                // INSERT INTO table (columns) VALUES (expressions);
                // как-то сделать запрос
                // таблшица, - это есть, это мы знаем как найти
                // колонка, - ? где достать список колонок для каждой конкретной таблицы? ДЛЯ ПРОГРАММЫ
                // текстбоксы
                // "insert into univer.cathedra (Name_of_cathedra...) values (" + nameCathedraCt + "" + ....
                if (args.length == 0) {
                    throw new SQLException("No arguments were provided for INSERT statement.");
                } else {
                    ArrayList<SQLTableColumnsInfo> columnsData = getColumnsData(args[0]);

                    if (args.length != columnsData.size() + 1) {
                        throw new SQLException("Invalid amount of arguments for current table to perform INSERTion.");
                    }

                    if (columnsData.size() != 0) {
                        StringBuilder queryBuilder = new StringBuilder();
                        queryBuilder.append("INSERT INTO ").append(DB_SCHEMA_NAME).append(".").append(args[0]).append(" (");

                        for (int i = 0; i < columnsData.size(); i++) {
                            queryBuilder.append(columnsData.get(i).getColumnName());

                            if (i < columnsData.size() - 1)
                                queryBuilder.append(",");
                        }

                        queryBuilder.append(") VALUES (");

                        for (int j = 0; j < columnsData.size(); j++) {
                            if (columnsData.get(j).getColumnType().contains("varchar")) {
                                queryBuilder.append(
                                        getSQLString(
                                                getVarchar255Arg(
                                                        args[j + 1],
                                                        columnsData.get(j).getIsPrimary()
                                                )
                                        )
                                );
                            } else {
                                queryBuilder.append(
                                        getInt11Arg(
                                                args[j + 1],
                                                columnsData.get(j).getIsPrimary()
                                        )
                                );
                            }

                            if (j < columnsData.size() - 1)
                                queryBuilder.append(",");
                        }

                        queryBuilder.append(");");

                        Statement insertion = DB_CONNECTION.createStatement();
                        int insertionResult = insertion.executeUpdate(queryBuilder.toString());
                        System.out.println("Insert was performed with code: " + insertionResult);
                    }
                }
                break;
            }
        }

        return result;
    }
}
