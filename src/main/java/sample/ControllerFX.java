package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Tables.Cathedra;
import sample.Tables.EducationBuilding;
import sample.Tables.Faculty;

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

    @FXML // fx:id="TableFaculty"
    private TableView<Faculty> TableFaculty; // Value injected by FXMLLoader

    @FXML // fx:id="TableStudent"
    private TableView<?> TableStudent; // Value injected by FXMLLoader

    @FXML // fx:id="TableEB"
    private TableView<EducationBuilding> TableEB; // Value injected by FXMLLoader

    @FXML // fx:id="TableStudentsGroup"
    private TableView<?> TableStudentsGroup; // Value injected by FXMLLoader

    @FXML // fx:id="TableTeacher"
    private TableView<?> TableTeacher; // Value injected by FXMLLoader

    @FXML // fx:id="TableCathedra"
    private TableView<Cathedra> TableCathedra; // Value injected by FXMLLoader

    @FXML
    private TableColumn<?, ?> ColumnStudent1;

    @FXML
    private TableColumn<?, ?> ColumnStudent2;

    @FXML
    private TableColumn<?, ?> ColumnStudent3;

    @FXML
    private TableColumn<?, ?> ColumnStudent4;

    @FXML
    private TableColumn<Cathedra, Integer> ColumnCath4;

    @FXML
    private TableColumn<Cathedra, String> ColumnCath1;

    @FXML
    private TableColumn<Cathedra, Integer> ColumnCath3;

    @FXML
    private TableColumn<Cathedra, String> ColumnCath2;

    @FXML
    private TableColumn<?, ?> ColumnStudentsGroup4;

    @FXML
    private TableColumn<?, ?> ColumnStudentsGroup3;

    @FXML
    private TableColumn<?, ?> ColumnStudentsGroup2;

    @FXML
    private TableColumn<?, ?> ColumnStudentsGroup1;

    @FXML
    private TableColumn<?, ?> ColumnStudentsGroup5;

    @FXML
    private TableColumn<?, ?> ColumnEB1;

    @FXML
    private TableColumn<?, ?> ColumnEB2;

    @FXML
    private TableColumn<?, ?> ColumnFaculty1;

    @FXML
    private TableColumn<?, ?> ColumnFaculty3;

    @FXML
    private TableColumn<?, ?> ColumnFaculty2;

    @FXML
    private TableColumn<?, ?> ColumnEB3;

    @FXML
    private TableColumn<?, ?> ColumnFaculty4;

    @FXML
    private TableColumn<?, ?> ColumnTeacher1;

    @FXML
    private TableColumn<?, ?> ColumnTeacher3;

    @FXML
    private TableColumn<?, ?> ColumnTeacher2;

    @FXML
    private TableColumn<?, ?> ColumnTeacher5;

    @FXML
    private TableColumn<?, ?> ColumnTeacher4;

    @FXML
    private TableColumn<?, ?> ColumnTeacher7;

    @FXML
    private TableColumn<?, ?> ColumnTeacher6;

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws SQLException, ClassNotFoundException {
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
        assert TableFaculty != null : "fx:id=\"TableFaculty\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameGroupStuGro_upd != null : "fx:id=\"nameGroupStuGro_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert dean != null : "fx:id=\"dean\" was not injected: check your FXML file 'sample.fxml'.";
        assert ColumnStudent1 != null : "fx:id=\"ColumnStudent1\" was not injected: check your FXML file 'sample.fxml'.";
        assert ColumnStudent2 != null : "fx:id=\"ColumnStudent2\" was not injected: check your FXML file 'sample.fxml'.";
        assert ColumnStudent3 != null : "fx:id=\"ColumnStudent3\" was not injected: check your FXML file 'sample.fxml'.";
        assert ColumnStudent4 != null : "fx:id=\"ColumnStudent4\" was not injected: check your FXML file 'sample.fxml'.";
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
        assert TableStudent != null : "fx:id=\"TableStudent\" was not injected: check your FXML file 'sample.fxml'.";
        assert ColumnCath4 != null : "fx:id=\"ColumnCath4\" was not injected: check your FXML file 'sample.fxml'.";
        assert ColumnCath1 != null : "fx:id=\"ColumnCath1\" was not injected: check your FXML file 'sample.fxml'.";
        assert ColumnCath3 != null : "fx:id=\"ColumnCath3\" was not injected: check your FXML file 'sample.fxml'.";
        assert phoneDean != null : "fx:id=\"phoneDean\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameCourse != null : "fx:id=\"nameCourse\" was not injected: check your FXML file 'sample.fxml'.";
        assert ColumnCath2 != null : "fx:id=\"ColumnCath2\" was not injected: check your FXML file 'sample.fxml'.";
        assert TableEB != null : "fx:id=\"TableEB\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameFacultuStuGro_upd != null : "fx:id=\"nameFacultuStuGro_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameFacultuStuGro != null : "fx:id=\"nameFacultuStuGro\" was not injected: check your FXML file 'sample.fxml'.";
        assert StudentUpdate != null : "fx:id=\"StudentUpdate\" was not injected: check your FXML file 'sample.fxml'.";
        assert EDAdd != null : "fx:id=\"EDAdd\" was not injected: check your FXML file 'sample.fxml'.";
        assert FacultyUpdate != null : "fx:id=\"FacultyUpdate\" was not injected: check your FXML file 'sample.fxml'.";
        assert ColumnStudentsGroup4 != null : "fx:id=\"ColumnStudentsGroup4\" was not injected: check your FXML file 'sample.fxml'.";
        assert ColumnStudentsGroup3 != null : "fx:id=\"ColumnStudentsGroup3\" was not injected: check your FXML file 'sample.fxml'.";
        assert ColumnStudentsGroup2 != null : "fx:id=\"ColumnStudentsGroup2\" was not injected: check your FXML file 'sample.fxml'.";
        assert teacher_rb != null : "fx:id=\"teacher_rb\" was not injected: check your FXML file 'sample.fxml'.";
        assert ColumnStudentsGroup1 != null : "fx:id=\"ColumnStudentsGroup1\" was not injected: check your FXML file 'sample.fxml'.";
        assert CathedraDel != null : "fx:id=\"CathedraDel\" was not injected: check your FXML file 'sample.fxml'.";
        assert StudentsGroup_update != null : "fx:id=\"StudentsGroup_update\" was not injected: check your FXML file 'sample.fxml'.";
        assert EDUpdate != null : "fx:id=\"EDUpdate\" was not injected: check your FXML file 'sample.fxml'.";
        assert ColumnStudentsGroup5 != null : "fx:id=\"ColumnStudentsGroup5\" was not injected: check your FXML file 'sample.fxml'.";
        assert phone_upd != null : "fx:id=\"phone_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert ColumnEB1 != null : "fx:id=\"ColumnEB1\" was not injected: check your FXML file 'sample.fxml'.";
        assert personalNumberTeacher != null : "fx:id=\"personalNumberTeacher\" was not injected: check your FXML file 'sample.fxml'.";
        assert ColumnEB2 != null : "fx:id=\"ColumnEB2\" was not injected: check your FXML file 'sample.fxml'.";
        assert jobTittle != null : "fx:id=\"jobTittle\" was not injected: check your FXML file 'sample.fxml'.";
        assert TableStudentsGroup != null : "fx:id=\"TableStudentsGroup\" was not injected: check your FXML file 'sample.fxml'.";
        assert TableTeacher != null : "fx:id=\"TableTeacher\" was not injected: check your FXML file 'sample.fxml'.";
        assert Faculty_update != null : "fx:id=\"Faculty_update\" was not injected: check your FXML file 'sample.fxml'.";
        assert numberStudents != null : "fx:id=\"numberStudents\" was not injected: check your FXML file 'sample.fxml'.";
        assert Faculty_add != null : "fx:id=\"Faculty_add\" was not injected: check your FXML file 'sample.fxml'.";
        assert ColumnFaculty1 != null : "fx:id=\"ColumnFaculty1\" was not injected: check your FXML file 'sample.fxml'.";
        assert headDepartment != null : "fx:id=\"headDepartment\" was not injected: check your FXML file 'sample.fxml'.";
        assert ColumnFaculty3 != null : "fx:id=\"ColumnFaculty3\" was not injected: check your FXML file 'sample.fxml'.";
        assert ColumnFaculty2 != null : "fx:id=\"ColumnFaculty2\" was not injected: check your FXML file 'sample.fxml'.";
        assert pane_del != null : "fx:id=\"pane_del\" was not injected: check your FXML file 'sample.fxml'.";
        assert StudentsGroupUpdate != null : "fx:id=\"StudentsGroupUpdate\" was not injected: check your FXML file 'sample.fxml'.";
        assert ColumnEB3 != null : "fx:id=\"ColumnEB3\" was not injected: check your FXML file 'sample.fxml'.";
        assert ColumnFaculty4 != null : "fx:id=\"ColumnFaculty4\" was not injected: check your FXML file 'sample.fxml'.";
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
        assert ColumnTeacher1 != null : "fx:id=\"ColumnTeacher1\" was not injected: check your FXML file 'sample.fxml'.";
        assert ColumnTeacher3 != null : "fx:id=\"ColumnTeacher3\" was not injected: check your FXML file 'sample.fxml'.";
        assert ColumnTeacher2 != null : "fx:id=\"ColumnTeacher2\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameGroupStuGrou != null : "fx:id=\"nameGroupStuGrou\" was not injected: check your FXML file 'sample.fxml'.";
        assert ColumnTeacher5 != null : "fx:id=\"ColumnTeacher5\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameCathedraStuGro_upd != null : "fx:id=\"nameCathedraStuGro_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert ColumnTeacher4 != null : "fx:id=\"ColumnTeacher4\" was not injected: check your FXML file 'sample.fxml'.";
        assert update != null : "fx:id=\"update\" was not injected: check your FXML file 'sample.fxml'.";
        assert ColumnTeacher7 != null : "fx:id=\"ColumnTeacher7\" was not injected: check your FXML file 'sample.fxml'.";
        assert Student_update != null : "fx:id=\"Student_update\" was not injected: check your FXML file 'sample.fxml'.";
        assert ColumnTeacher6 != null : "fx:id=\"ColumnTeacher6\" was not injected: check your FXML file 'sample.fxml'.";
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
        assert TableCathedra != null : "fx:id=\"TableCathedra\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameFaculty_del != null : "fx:id=\"nameFaculty_del\" was not injected: check your FXML file 'sample.fxml'.";
        assert numberEDCath_upd != null : "fx:id=\"numberEDCath_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert EB_rb != null : "fx:id=\"EB_rb\" was not injected: check your FXML file 'sample.fxml'.";
        assert phoneDean_upd != null : "fx:id=\"phoneDean_upd\" was not injected: check your FXML file 'sample.fxml'.";
        assert numberRecordBook_del != null : "fx:id=\"numberRecordBook_del\" was not injected: check your FXML file 'sample.fxml'.";
        assert tab_view != null : "fx:id=\"tab_view\" was not injected: check your FXML file 'sample.fxml'.";
        assert Teacher_add != null : "fx:id=\"Teacher_add\" was not injected: check your FXML file 'sample.fxml'.";
        assert addressTeach != null : "fx:id=\"addressTeach\" was not injected: check your FXML file 'sample.fxml'.";


        ColumnCath1.setCellValueFactory(new PropertyValueFactory<>("name_cathedra"));
        ColumnCath2.setCellValueFactory(new PropertyValueFactory<>("head_department"));
        ColumnCath3.setCellValueFactory(new PropertyValueFactory<>("phone_department"));
        ColumnCath4.setCellValueFactory(new PropertyValueFactory<>("number_EB"));

        ColumnEB1.setCellValueFactory(new PropertyValueFactory<>("number_EB"));
        ColumnEB2.setCellValueFactory(new PropertyValueFactory<>("address"));
        ColumnEB3.setCellValueFactory(new PropertyValueFactory<>("phone_EB"));

        ColumnFaculty1.setCellValueFactory(new PropertyValueFactory<>("name_faculty"));
        ColumnFaculty2.setCellValueFactory(new PropertyValueFactory<>("dean"));
        ColumnFaculty3.setCellValueFactory(new PropertyValueFactory<>("phone_dean"));
        ColumnFaculty4.setCellValueFactory(new PropertyValueFactory<>("number_students"));

        DB_CONNECTION = getConnection();
        if (DB_CONNECTION != null)
            System.out.println("Got a connection!");

       /*ResultSet test2 = getResultFromDB(
                        SQLQueryType.SELECT,
                        "cathedra",
                        "head_of_department",
                        getSQLString("Vahidov")
                );*/

              /*  while (test2.next()) {
                    System.out.println(test2.getString(2));
                }*/

                /*ResultSet testAdd1 = getResultFromDB(
                        SQLQueryType.INSERT,
                        "cathedra",
                        "TestCathedra2",
                        "TestHeadOfDepartment",
                        "4368236",
                        "6"
                );

                ResultSet test = getResultFromDB(
                        SQLQueryType.SELECT,
                        "cathedra"
                );*/

                /*while (test.next()) {
                    System.out.println(test.getString(1));
                }*/


        cathedra_rb.setOnAction(event1 -> {
            EDAdd.setVisible(false);
            StudentAdd.setVisible(false);
            StudentsGroupAdd.setVisible(false);
            TeacherAdd.setVisible(false);
            FacultyAdd.setVisible(false);
            CathedraAdd.setVisible(true);
            add.setVisible(true);

            EDDel.setVisible(false);
            StudentDel.setVisible(false);
            StudentsGroupDel.setVisible(false);
            TeacherDel.setVisible(false);
            FacultyDel.setVisible(false);
            CathedraDel.setVisible(true);
            delete.setVisible(true);

            EDUpdate.setVisible(false);
            StudentUpdate.setVisible(false);
            StudentsGroupUpdate.setVisible(false);
            TeacherUpdate.setVisible(false);
            FacultyUpdate.setVisible(false);
            CathedraUpdate.setVisible(true);
            update.setVisible(true);

            TableCathedra.setVisible(true);
            TableEB.setVisible(false);
            TableFaculty.setVisible(false);
            TableStudent.setVisible(false);
            TableStudentsGroup.setVisible(false);
            TableTeacher.setVisible(false);


            try {
                SetTableValues(SQLTable.CATHEDRA);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //если нажата кнопка добавить запись то вызываем функцию с определенным типом запроса для опред талицы
            add.setOnAction(event2 -> {

                // AddToDatabase(SQLTable.CATHEDRA, SQLQueryType.INSERT);
                String textCathAdd1 = new String();
                textCathAdd1 = nameCathedraCath.getText();
                String textCathAdd2 = new String();
                textCathAdd2 = headDepartment.getText();
                String textCathAdd3 = "";
                textCathAdd3 = phoneDepartment.getText();
                String textCathAdd4 = new String();
                textCathAdd4 = numberEDCath.getText();

                try {
                    getResultFromDB(SQLQueryType.INSERT, "cathedra", textCathAdd1, textCathAdd2, textCathAdd3, textCathAdd4);
                    SetTableValues(SQLTable.CATHEDRA);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            delete.setOnAction(event2 -> {
                //DeleteFromDatabase(SQLTable.CATHEDRA, SQLQueryType.DELETE);
                String textCathDel = new String();
                textCathDel = nameCathedra_del.getText();
                StringBuilder queryBuilder = new StringBuilder();
                queryBuilder.append("DELETE FROM univer.cathedra WHERE Name_of_the_cathedra='").append(textCathDel).append("';");
                try {
                    Statement insertion = DB_CONNECTION.createStatement();
                    insertion.executeUpdate(queryBuilder.toString());
                    nameCathedra_del.clear();
                    SetTableValues(SQLTable.CATHEDRA);

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            update.setOnAction(event2 -> {
                // UpdateDatabase(SQLTable.CATHEDRA, SQLQueryType.UPDATE);
                String textCathUpd1 = new String();
                textCathUpd1 = nameCathedraCath_upd.getText();
                String textCathUpd2 = new String();
                textCathUpd2 = headDepartment_upd.getText();
                String textCathUpd3 = new String();
                textCathUpd3 = phoneDepartment_upd.getText();
                String textCathUpd4 = new String();
                textCathUpd4 = numberEDCath_upd.getText();
                StringBuilder queryBuilder = new StringBuilder();
                queryBuilder.append("UPDATE univer.cathedra SET Head_of_department='").append(textCathUpd2).append("', Phone_of_the_department='").append(textCathUpd3).append("', Number_of_the_education_building='").append(textCathUpd4).append("' WHERE Name_of_the_cathedra='").append(textCathUpd1).append("';");
                try {
                    Statement insertion = DB_CONNECTION.createStatement();
                    insertion.executeUpdate(queryBuilder.toString());
                    nameCathedraCath_upd.clear();
                    headDepartment_upd.clear();
                    phoneDepartment_upd.clear();
                    numberEDCath_upd.clear();
                    SetTableValues(SQLTable.CATHEDRA);

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            });

        });

        student_rb.setOnAction(event1 -> {
            EDAdd.setVisible(false);
            StudentAdd.setVisible(true);
            StudentsGroupAdd.setVisible(false);
            TeacherAdd.setVisible(false);
            FacultyAdd.setVisible(false);
            CathedraAdd.setVisible(false);
            add.setVisible(true);

            EDDel.setVisible(false);
            StudentDel.setVisible(true);
            StudentsGroupDel.setVisible(false);
            TeacherDel.setVisible(false);
            FacultyDel.setVisible(false);
            CathedraDel.setVisible(false);
            delete.setVisible(true);

            EDUpdate.setVisible(false);
            StudentUpdate.setVisible(true);
            StudentsGroupUpdate.setVisible(false);
            TeacherUpdate.setVisible(false);
            FacultyUpdate.setVisible(false);
            CathedraUpdate.setVisible(false);
            update.setVisible(true);

            TableCathedra.setVisible(false);
            TableEB.setVisible(false);
            TableFaculty.setVisible(false);
            TableStudent.setVisible(true);
            TableStudentsGroup.setVisible(false);
            TableTeacher.setVisible(false);

            add.setOnAction(event2 -> {
                //AddToDatabase(SQLTable.STUDENT, SQLQueryType.INSERT);
                String textStudentAdd1 = new String();
                textStudentAdd1 = numberRecordBook.getText();
                String textStudentAdd2 = new String();
                textStudentAdd2 = lastNameStudent.getText();
                String textStudentAdd3 = new String();
                textStudentAdd3 = yearBirth.getText();
                String textStudentAdd4 = new String();
                textStudentAdd4 = nameGroupStu.getText();


            });
            delete.setOnAction(event2 -> {
                //DeleteFromDatabase(SQLTable.STUDENT, SQLQueryType.DELETE);
                String textStudentDel = new String();
                textStudentDel = numberRecordBook_del.getText();
                StringBuilder queryBuilder = new StringBuilder();
                queryBuilder.append("DELETE FROM univer.student WHERE Number_record_book='").append(textStudentDel).append("';");
                try {
                    Statement insertion = DB_CONNECTION.createStatement();
                    insertion.executeUpdate(queryBuilder.toString());
                    numberRecordBook_del.clear();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            update.setOnAction(event2 -> {
                //UpdateDatabase(SQLTable.STUDENT, SQLQueryType.UPDATE);
                String textStudentUpd1 = new String();
                textStudentUpd1 = numberRecordBook_upd.getText();
                String textStudentUpd2 = new String();
                textStudentUpd2 = lastNameStudent_upd.getText();
                String textStudentUpd3 = new String();
                textStudentUpd3 = yearBirth_upd.getText();
                String textStudentUpd4 = new String();
                textStudentUpd4 = nameGroupStu_upd.getText();
                StringBuilder queryBuilder = new StringBuilder();
                queryBuilder.append("UPDATE univer.student SET Last_name='").append(textStudentUpd2).append("', Year_of_birth='").append(textStudentUpd3).append("', Name_of_the_group='").append(textStudentUpd4).append("' WHERE Number_record_book='").append(textStudentUpd1).append("';");
                try {
                    Statement insertion = DB_CONNECTION.createStatement();
                    insertion.executeUpdate(queryBuilder.toString());
                    numberRecordBook_upd.clear();
                    lastNameStudent_upd.clear();
                    yearBirth_upd.clear();
                    nameGroupStu_upd.clear();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        });

        faculty_rb.setOnAction(event1 -> {
            EDAdd.setVisible(false);
            StudentAdd.setVisible(false);
            StudentsGroupAdd.setVisible(false);
            TeacherAdd.setVisible(false);
            FacultyAdd.setVisible(true);
            CathedraAdd.setVisible(false);
            add.setVisible(true);

            EDDel.setVisible(false);
            StudentDel.setVisible(false);
            StudentsGroupDel.setVisible(false);
            TeacherDel.setVisible(false);
            FacultyDel.setVisible(true);
            CathedraDel.setVisible(false);
            delete.setVisible(true);

            EDUpdate.setVisible(false);
            StudentUpdate.setVisible(false);
            StudentsGroupUpdate.setVisible(false);
            TeacherUpdate.setVisible(false);
            FacultyUpdate.setVisible(true);
            CathedraUpdate.setVisible(false);
            update.setVisible(true);

            TableCathedra.setVisible(false);
            TableEB.setVisible(false);
            TableFaculty.setVisible(true);
            TableStudent.setVisible(false);
            TableStudentsGroup.setVisible(false);
            TableTeacher.setVisible(false);

            try {
                SetTableValues(SQLTable.FACULTY);
            } catch (Exception e) {
                e.printStackTrace();
            }

            add.setOnAction(event2 -> {
                // AddToDatabase(SQLTable.FACULTY, SQLQueryType.INSERT);
                String textFacultyAdd1 = new String();
                textFacultyAdd1 = nameFacultyFac.getText();
                String textFacultyAdd2 = new String();
                textFacultyAdd2 = dean.getText();
                String textFacultyAdd3 = new String();
                textFacultyAdd3 = phoneDean.getText();
                String textFacultyAdd4 = new String();
                textFacultyAdd4 = numberStudents.getText();


                try {
                    getResultFromDB(SQLQueryType.INSERT, "faculty", textFacultyAdd1, textFacultyAdd2, textFacultyAdd3, textFacultyAdd4);
                    SetTableValues(SQLTable.FACULTY);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            delete.setOnAction(event2 -> {
                //DeleteFromDatabase(SQLTable.FACULTY, SQLQueryType.DELETE);
                String textFacultyDel = new String();
                textFacultyDel = nameFaculty_del.getText();
                StringBuilder queryBuilder = new StringBuilder();
                queryBuilder.append("DELETE FROM univer.faculty WHERE Name_of_the_faculty='").append(textFacultyDel).append("';");
                try {
                    Statement insertion = DB_CONNECTION.createStatement();
                    insertion.executeUpdate(queryBuilder.toString());
                    nameFaculty_del.clear();
                    SetTableValues(SQLTable.FACULTY);

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
            update.setOnAction(event2 -> {
                //UpdateDatabase(SQLTable.FACULTY, SQLQueryType.UPDATE);
                String textFacultyUpd1 = new String();
                textFacultyUpd1 = nameFacultyFac_upd.getText();
                String textFacultyUpd2 = new String();
                textFacultyUpd2 = dean_upd.getText();
                String textFacultyUpd3 = new String();
                textFacultyUpd3 = phoneDean_upd.getText();
                String textFacultyUpd4 = new String();
                textFacultyUpd4 = numberStudents_upd.getText();
                StringBuilder queryBuilder = new StringBuilder();
                queryBuilder.append("UPDATE univer.faculty SET Dean='").append(textFacultyUpd2).append("', Phone_dean='").append(textFacultyUpd3).append("', Number_of_students_at_the_faculty='").append(textFacultyUpd4).append("' WHERE Name_of_the_faculty='").append(textFacultyUpd1).append("';");
                try {
                    Statement insertion = DB_CONNECTION.createStatement();
                    insertion.executeUpdate(queryBuilder.toString());
                    nameFacultyFac_upd.clear();
                    dean_upd.clear();
                    phoneDean_upd.clear();
                    numberStudents_upd.clear();
                    SetTableValues(SQLTable.FACULTY);

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });

        studentsGroup_rb.setOnAction(event1 -> {
            EDAdd.setVisible(false);
            StudentAdd.setVisible(false);
            StudentsGroupAdd.setVisible(true);
            TeacherAdd.setVisible(false);
            FacultyAdd.setVisible(false);
            CathedraAdd.setVisible(false);
            add.setVisible(true);

            EDDel.setVisible(false);
            StudentDel.setVisible(false);
            StudentsGroupDel.setVisible(true);
            TeacherDel.setVisible(false);
            FacultyDel.setVisible(false);
            CathedraDel.setVisible(false);
            delete.setVisible(true);

            EDUpdate.setVisible(false);
            StudentUpdate.setVisible(false);
            StudentsGroupUpdate.setVisible(true);
            TeacherUpdate.setVisible(false);
            FacultyUpdate.setVisible(false);
            CathedraUpdate.setVisible(false);
            update.setVisible(true);

            TableCathedra.setVisible(false);
            TableEB.setVisible(false);
            TableFaculty.setVisible(false);
            TableStudent.setVisible(false);
            TableStudentsGroup.setVisible(true);
            TableTeacher.setVisible(false);

            add.setOnAction(event2 -> {
                //  AddToDatabase(SQLTable.GROUP, SQLQueryType.INSERT);
                String textStuGroupAdd1 = new String();
                textStuGroupAdd1 = nameGroupStuGrou.getText();
                String textStuGroupAdd2 = new String();
                textStuGroupAdd2 = nameFacultuStuGro.getText();
                String textStuGroupAdd3 = new String();
                textStuGroupAdd3 = nameCourse.getText();
                String textStuGroupAdd4 = new String();
                textStuGroupAdd4 = direction.getText();
                String textStuGroupAdd5 = new String();
                textStuGroupAdd5 = nameCathedraStuGro.getText();

                try {
                    getResultFromDB(SQLQueryType.INSERT, "students_group", textStuGroupAdd1, textStuGroupAdd2, textStuGroupAdd3, textStuGroupAdd4, textStuGroupAdd5);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            delete.setOnAction(event2 -> {
                //DeleteFromDatabase(SQLTable.GROUP, SQLQueryType.DELETE);
                String textStuGroupDel = new String();
                textStuGroupDel = nameGroup_del.getText();
                StringBuilder queryBuilder = new StringBuilder();
                queryBuilder.append("DELETE FROM univer.students_group WHERE Name_of_the_group='").append(textStuGroupDel).append("';");
                try {
                    Statement insertion = DB_CONNECTION.createStatement();
                    insertion.executeUpdate(queryBuilder.toString());
                    nameGroup_del.clear();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            update.setOnAction(event2 -> {
                // UpdateDatabase(SQLTable.GROUP, SQLQueryType.UPDATE);
                String textStuGroupUpd1 = new String();
                textStuGroupUpd1 = nameGroupStuGro_upd.getText();
                String textStuGroupUpd2 = new String();
                textStuGroupUpd2 = nameFacultuStuGro_upd.getText();
                String textStuGroupUpd3 = new String();
                textStuGroupUpd3 = nameCourse_upd.getText();
                String textStuGroupUpd4 = new String();
                textStuGroupUpd4 = direction_upd.getText();
                String textStuGroupUpd5 = new String();
                textStuGroupUpd5 = nameCathedraStuGro_upd.getText();
                StringBuilder queryBuilder = new StringBuilder();
                queryBuilder.append("UPDATE univer.students_group SET Name_of_the_faculty='").append(textStuGroupUpd2).append("', Number_of_course='").append(textStuGroupUpd3).append("', Direction='").append(textStuGroupUpd4).append("', Name_of_cathedra='").append(textStuGroupUpd5).append("' WHERE Name_of_the_group='").append(textStuGroupUpd1).append("';");
                try {
                    Statement insertion = DB_CONNECTION.createStatement();
                    insertion.executeUpdate(queryBuilder.toString());
                    nameGroupStuGro_upd.clear();
                    nameFacultuStuGro_upd.clear();
                    nameCourse_upd.clear();
                    direction_upd.clear();
                    nameCathedraStuGro_upd.clear();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        });

        teacher_rb.setOnAction(event1 -> {
            EDAdd.setVisible(false);
            StudentAdd.setVisible(false);
            StudentsGroupAdd.setVisible(false);
            TeacherAdd.setVisible(true);
            FacultyAdd.setVisible(false);
            CathedraAdd.setVisible(false);
            add.setVisible(true);

            EDDel.setVisible(false);
            StudentDel.setVisible(false);
            StudentsGroupDel.setVisible(false);
            TeacherDel.setVisible(true);
            FacultyDel.setVisible(false);
            CathedraDel.setVisible(false);
            delete.setVisible(true);

            EDUpdate.setVisible(false);
            StudentUpdate.setVisible(false);
            StudentsGroupUpdate.setVisible(false);
            TeacherUpdate.setVisible(true);
            FacultyUpdate.setVisible(false);
            CathedraUpdate.setVisible(false);
            update.setVisible(true);

            TableCathedra.setVisible(false);
            TableEB.setVisible(false);
            TableFaculty.setVisible(false);
            TableStudent.setVisible(false);
            TableStudentsGroup.setVisible(false);
            TableTeacher.setVisible(true);

            add.setOnAction(event2 -> {
                //AddToDatabase(SQLTable.TEACHER, SQLQueryType.INSERT);
                String textTeacherAdd1 = new String();
                textTeacherAdd1 = personalNumberTeacher.getText();
                String textTeacherAdd2 = new String();
                textTeacherAdd2 = lastNameTeacher.getText();
                String textTeacherAdd3 = new String();
                textTeacherAdd3 = jobTittle.getText();
                String textTeacherAdd4 = new String();
                textTeacherAdd4 = degree.getText();
                String textTeacherAdd5 = new String();
                textTeacherAdd5 = nameCathedraTeach.getText();
                String textTeacherAdd6 = new String();
                textTeacherAdd6 = phone.getText();
                String textTeacherAdd7 = new String();
                textTeacherAdd7 = addressTeach.getText();

                try {
                    getResultFromDB(SQLQueryType.INSERT, "teacher", textTeacherAdd1, textTeacherAdd2, textTeacherAdd3, textTeacherAdd4, textTeacherAdd5, textTeacherAdd6, textTeacherAdd7);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            delete.setOnAction(event2 -> {
                //DeleteFromDatabase(SQLTable.TEACHER, SQLQueryType.DELETE);
                String textTeacherDel = new String();
                textTeacherDel = personalNumberTeach_del.getText();
                StringBuilder queryBuilder = new StringBuilder();
                queryBuilder.append("DELETE FROM univer.teacher WHERE Personal_number_teacher='").append(textTeacherDel).append("';");
                try {
                    Statement insertion = DB_CONNECTION.createStatement();
                    insertion.executeUpdate(queryBuilder.toString());
                    personalNumberTeach_del.clear();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            update.setOnAction(event2 -> {
                // UpdateDatabase(SQLTable.TEACHER, SQLQueryType.UPDATE);
                String textTeacherUpd1 = new String();
                textTeacherUpd1 = personalNumberTeacher_upd.getText();
                String textTeacherUpd2 = new String();
                textTeacherUpd2 = lastNameTeacher_upd.getText();
                String textTeacherUpd3 = new String();
                textTeacherUpd3 = jobTittle_upd.getText();
                String textTeacherUpd4 = new String();
                textTeacherUpd4 = degree_upd.getText();
                String textTeacherUpd5 = new String();
                textTeacherUpd5 = nameCathedraTeach_upd.getText();
                String textTeacherUpd6 = new String();
                textTeacherUpd6 = phone_upd.getText();
                String textTeacherUpd7 = new String();
                textTeacherUpd7 = addressTeach_upd.getText();
                StringBuilder queryBuilder = new StringBuilder();
                queryBuilder.append("UPDATE univer.teacher SET Last_name='").append(textTeacherUpd2).append("', Job_title='").append(textTeacherUpd3).append("', Degree='").append(textTeacherUpd4).append("', Name_of_the_cathedra='").append(textTeacherUpd5).append("', Phone='").append(textTeacherUpd6).append("', Address='").append(textTeacherUpd6).append("' WHERE Personal_number_teacher='").append(textTeacherUpd1).append("';");
                try {
                    Statement insertion = DB_CONNECTION.createStatement();
                    insertion.executeUpdate(queryBuilder.toString());
                    personalNumberTeacher_upd.clear();
                    lastNameTeacher_upd.clear();
                    jobTittle_upd.clear();
                    degree_upd.clear();
                    nameCathedraTeach_upd.clear();
                    phone_upd.clear();
                    addressTeach_upd.clear();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        });

        EB_rb.setOnAction(event1 -> {
            EDAdd.setVisible(true);
            StudentAdd.setVisible(false);
            StudentsGroupAdd.setVisible(false);
            TeacherAdd.setVisible(false);
            FacultyAdd.setVisible(false);
            CathedraAdd.setVisible(false);
            add.setVisible(true);

            EDDel.setVisible(true);
            StudentDel.setVisible(false);
            StudentsGroupDel.setVisible(false);
            TeacherDel.setVisible(false);
            FacultyDel.setVisible(false);
            CathedraDel.setVisible(false);
            delete.setVisible(true);

            EDUpdate.setVisible(true);
            StudentUpdate.setVisible(false);
            StudentsGroupUpdate.setVisible(false);
            TeacherUpdate.setVisible(false);
            FacultyUpdate.setVisible(false);
            CathedraUpdate.setVisible(false);
            update.setVisible(true);

            TableCathedra.setVisible(false);
            TableEB.setVisible(true);
            TableFaculty.setVisible(false);
            TableStudent.setVisible(false);
            TableStudentsGroup.setVisible(false);
            TableTeacher.setVisible(false);

            try {
                SetTableValues(SQLTable.EDUCATION_BUILDING);
            } catch (Exception e) {
                e.printStackTrace();
            }
            add.setOnAction(event2 -> {

                // AddToDatabase(SQLTable.EDUCATION_BUILDING, SQLQueryType.INSERT);
                String textEDAdd1 = new String();
                textEDAdd1 = NumberED.getText();
                String textEDAdd2 = new String();
                textEDAdd2 = addressEB.getText();
                String textEDAdd3 = new String();
                textEDAdd3 = phoneDisp.getText();

                try {
                    getResultFromDB(SQLQueryType.INSERT, "education_building", textEDAdd1, textEDAdd2, textEDAdd3);
                    SetTableValues(SQLTable.EDUCATION_BUILDING);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
            delete.setOnAction(event2 -> {
                //DeleteFromDatabase(SQLTable.EDUCATION_BUILDING, SQLQueryType.DELETE);
                String textEDDel = new String();
                textEDDel = numberED_del.getText();
                StringBuilder queryBuilder = new StringBuilder();
                queryBuilder.append("DELETE FROM univer.education_building WHERE Number_of_the_education_building='").append(textEDDel).append("';");
                try {
                    Statement insertion = DB_CONNECTION.createStatement();
                    insertion.executeUpdate(queryBuilder.toString());
                    numberED_del.clear();
                    SetTableValues(SQLTable.EDUCATION_BUILDING);


                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            update.setOnAction(event2 -> {
                //UpdateDatabase(SQLTable.EDUCATION_BUILDING, SQLQueryType.UPDATE);
                String textEDUpd1 = new String();
                textEDUpd1 = NumberED_upd.getText();
                String textEDUpd2 = new String();
                textEDUpd2 = addressEB_upd.getText();
                String textEDUpd3 = new String();
                textEDUpd3 = phoneDisp_upd.getText();
                StringBuilder queryBuilder = new StringBuilder();
                queryBuilder.append("UPDATE univer.education_building SET Address='").append(textEDUpd2).append("', Phone_dispatcher='").append(textEDUpd3).append("' WHERE Number_of_the_education_building='").append(textEDUpd1).append("';");
                try {
                    Statement insertion = DB_CONNECTION.createStatement();
                    insertion.executeUpdate(queryBuilder.toString());
                    NumberED_upd.clear();
                    addressEB_upd.clear();
                    phoneDisp_upd.clear();
                    SetTableValues(SQLTable.EDUCATION_BUILDING);

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });

    }


    public void setStage(Stage source) {
        this.guiRoot = source;
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

    private void SetTableValues(SQLTable table) throws Exception {
        ClearTables();

        switch (table) {
            case CATHEDRA: {
                ResultSet result = getResultFromDB(SQLQueryType.SELECT, table.name().toLowerCase());
                if (result == null) return;
                ArrayList<Cathedra> values = new ArrayList<>();
                while (result.next()) {
                    values.add(new Cathedra(
                            result.getString(1),
                            result.getString(2),
                            Integer.parseInt(result.getString(3)),
                            Integer.parseInt(result.getString(4))
                    ));
                }

                ObservableList<Cathedra> tableValues = FXCollections.observableArrayList(values);

                TableCathedra.setItems(tableValues);

                break;
            }
            case EDUCATION_BUILDING:{
                ResultSet result = getResultFromDB(SQLQueryType.SELECT, table.name().toLowerCase());
                if (result == null) return;
                ArrayList<EducationBuilding> values = new ArrayList<>();
                while (result.next()) {
                    values.add(new EducationBuilding(
                            Integer.parseInt(result.getString(1)),
                            result.getString(2),
                            Integer.parseInt(result.getString(3))
                    ));
                }

                ObservableList<EducationBuilding> tableValues = FXCollections.observableArrayList(values);

                TableEB.setItems(tableValues);

                break;
            }
            case FACULTY:{
                ResultSet result = getResultFromDB(SQLQueryType.SELECT, table.name().toLowerCase());
                if (result == null) return;
                ArrayList<Faculty> values = new ArrayList<>();
                while (result.next()) {
                    values.add(new Faculty(
                            result.getString(1),
                            result.getString(2),
                            Integer.parseInt(result.getString(3)),
                            Integer.parseInt(result.getString(4))
                    ));
                }

                ObservableList<Faculty> tableValues = FXCollections.observableArrayList(values);

                TableFaculty.setItems(tableValues);

                break;
            }


        }

    }

    private void ClearTables() {
        nameCathedraCath.clear();
        headDepartment.clear();
        phoneDepartment.clear();
        numberEDCath.clear();
        numberRecordBook.clear();
        lastNameStudent.clear();
        yearBirth.clear();
        nameGroupStu.clear();
        nameGroupStuGrou.clear();
        nameFacultuStuGro.clear();
        nameCourse.clear();
        direction.clear();
        nameCathedraStuGro.clear();
        personalNumberTeacher.clear();
        lastNameTeacher.clear();
        jobTittle.clear();
        degree.clear();
        nameCathedraTeach.clear();
        phone.clear();
        addressTeach.clear();
        NumberED.clear();
        addressEB.clear();
        phoneDisp.clear();
        nameFacultyFac.clear();
        dean.clear();
        phoneDean.clear();
        numberStudents.clear();
    }


}
