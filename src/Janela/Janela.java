package Janela;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Janela extends Application {

	private Stage janela;
	private Scene passo1;
	private Scene passo2;
	private Scene passo3;
	private Button proximoPassoP1 = new Button("Ir p/ passo 2 >>");

	private Button passoAnteriorP2 = new Button("<< Ir p/ anterior");
	private Button proximoPassoP2 = new Button("Ir p/ passo 3 >>");

	private Button passoAnteriorP3 = new Button("<< Ir p/ anterior");
	private Button fecharAplicacao = new Button("X fechar app X");

	@Override
	public void start(Stage primaryStage) throws Exception {
		janela = primaryStage;

		proximoPassoP1.getStyleClass().add("botoes");
		passoAnteriorP2.getStyleClass().add("botoes");
		proximoPassoP2.getStyleClass().add("botoes");
		passoAnteriorP3.getStyleClass().add("botoes");
		fecharAplicacao.getStyleClass().add("botoes");

		criarPasso1();
		criarPasso2();
		criarPasso3();

		janela.setScene(passo1);
		janela.setTitle("Wizard1");

		janela.show();
	}

	private void criarPasso1() {

		this.proximoPassoP1.setOnAction(e -> {
			this.janela.setScene(this.passo2);
			janela.setTitle("Wizard2");
		});

		HBox box = new HBox();
		box.setAlignment(Pos.CENTER);
		box.getChildren().add(this.proximoPassoP1);

		// utilizando o arquivo css
		String caminhoDoCSS = getClass().getResource("/Janela/Contador.css").toExternalForm();

		this.passo1 = new Scene(box, 400, 400);

		this.passo1.getStylesheets().add(caminhoDoCSS);
		// dfinindo a fonte do texto
		this.passo1.getStylesheets().add("https://fonts.googleapis.com/css?family=Oswald");
	}

	private void criarPasso2() {

		this.passoAnteriorP2.setOnAction(e -> {
			this.janela.setScene(this.passo1);
			janela.setTitle("Wizard1");
		});

		this.proximoPassoP2.setOnAction(e -> {
			this.janela.setScene(this.passo3);
			janela.setTitle("Wizard3");
		});

		VBox box = new VBox();
		box.setAlignment(Pos.CENTER);
		box.getChildren().add(this.passoAnteriorP2);
		box.getChildren().add(this.proximoPassoP2);

		// utilizando o arquivo css
		String caminhoDoCSS = getClass().getResource("/Janela/Contador.css").toExternalForm();

		this.passo2 = new Scene(box, 400, 400);

		this.passo2.getStylesheets().add(caminhoDoCSS);
		// dfinindo a fonte do texto
		this.passo2.getStylesheets().add("https://fonts.googleapis.com/css?family=Oswald");
	}

	private void criarPasso3() {

		this.passoAnteriorP3.setOnAction(e -> {
			this.janela.setScene(this.passo2);
			janela.setTitle("Wizard2");
		});

		this.fecharAplicacao.setOnAction(e -> {
			janela.setTitle("Fechando...");
			System.exit(0);
		});

		HBox box = new HBox();
		box.setAlignment(Pos.CENTER);
		box.getChildren().add(this.passoAnteriorP3);
		box.getChildren().add(this.fecharAplicacao);

		// utilizando o arquivo css
		String caminhoDoCSS = getClass().getResource("/Janela/Contador.css").toExternalForm();

		this.passo3 = new Scene(box, 400, 400);

		this.passo3.getStylesheets().add(caminhoDoCSS);
		// dfinindo a fonte do texto
		this.passo3.getStylesheets().add("https://fonts.googleapis.com/css?family=Oswald");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
