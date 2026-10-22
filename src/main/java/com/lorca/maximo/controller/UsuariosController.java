package com.lorca.maximo.controller;

import com.lorca.maximo.dao.UsuariosDao;
import com.lorca.maximo.dto.UsuarioDto;
import com.lorca.maximo.model.UsuariosModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.time.LocalDateTime;

public class UsuariosController {

    UsuarioDto usuarioEliminar;
    @FXML
    public TableView tableUsuarios;
    @FXML
    public TableColumn colId;
    @FXML
    public TableColumn colNombre;
    @FXML
    public TableColumn colContrasena;
    @FXML
    public TableColumn colCorreo;
    @FXML
    public TableColumn colEdad;
    @FXML
    public TableColumn<UsuarioDto, LocalDateTime> colFechaCreacion; // Agregar hora



    @FXML
    public TextField txtId;

    @FXML
    public Button btnEliminar;

    @FXML
    public Button btnActualizar;


    private UsuariosModel usuariosModel;
    private ObservableList<UsuarioDto> usuarios;
    private Integer idUsuario = 0;

    @FXML
    public TextField txtNombre;

    @FXML
    public TextField txtContrasena;

    @FXML
    public TextField txtCorreo;

    @FXML
    public TextField txtEdad;

    @FXML
    public Label lblResultado;
    UsuariosDao usuariosDao = new UsuariosDao();


    public UsuariosController() {
        this.usuariosModel = new UsuariosModel();
    }

    @FXML
    public void initialize() {
        this.colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colContrasena.setCellValueFactory(new PropertyValueFactory<>("contrasena"));
        this.colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        this.colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        this.colFechaCreacion.setCellValueFactory(new PropertyValueFactory<>("fechaCreacion")); // Agregar hora

        this.usuarios = FXCollections.observableArrayList();
        this.tableUsuarios.setItems(this.usuarios);
    }

    @FXML
    public void handleAgregarUsuario(ActionEvent actionEvent) {
        try {
            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setNombre(txtNombre.getText());
            usuarioDto.setContrasena(txtContrasena.getText());
            usuarioDto.setCorreo(txtCorreo.getText());
            usuarioDto.setEdad(Integer.parseInt(txtEdad.getText()));
            usuarioDto.setFechaCreacion(LocalDateTime.now()); // Hora
            usuarioDto.setId(this.getIdUsuario()); // Hora

            if (txtNombre.getText().trim().isEmpty() || txtContrasena.getText().trim().isEmpty()|| txtCorreo.getText().trim().isEmpty()|| txtEdad.getText().trim().isEmpty()) {
                throw new Exception("Datos no pueden estar vacio");
            }
            usuarioDto.setId(this.getIdUsuario());

            this.txtNombre.setText("");
            this.txtContrasena.setText("");
            this.txtCorreo.setText("");
            this.txtEdad.setText("");

            this.txtNombre.requestFocus();

            System.out.println("Agregando usuario");

            System.out.println(usuarioDto);
            this.usuariosModel.agregarUsuario(usuarioDto);
            System.out.println(this.usuariosModel.getUsuarios().size());

            this.usuarios.setAll(this.usuariosModel.getUsuarios());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    private Integer getIdUsuario() {
        this.idUsuario = this.idUsuario + 1;
        return idUsuario;
    }

    @FXML
    public void handleSeleccionar(MouseEvent mouseEvent) {
        UsuarioDto usuarioDto = (UsuarioDto) this.tableUsuarios.getSelectionModel().getSelectedItem();
        if (usuarioDto != null) {
            this.txtId.setText(usuarioDto.getId().toString());
            this.btnEliminar.setDisable(false);
            this.usuarioEliminar = usuarioDto;

        }
    }

    @FXML
    public void handleEliminarUsuario(ActionEvent actionEvent) {
        this.usuariosModel.eliminarUsuario(this.usuarioEliminar);
        this.usuarios.setAll(this.usuariosModel.getUsuarios());
        this.usuarioEliminar = null;
    }

    @FXML
    public void handleActualizarTabla(ActionEvent actionEvent) {  //Actualizar hora en tabla
        this.usuarios.setAll(this.usuariosModel.getUsuarios());
    }
    @FXML
    public void onGuardar(ActionEvent actionEvent) {
        String nombre = txtNombre.getText();
        this.usuariosDao.guardarNombre(nombre);
    }
    @FXML
    public void onLeer(ActionEvent actionEvent) {
        String nombre = this.usuariosDao.leerNombre();
        this.lblResultado.setText(nombre);
    }
}