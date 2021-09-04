package br.inatel.cdg.algebra.scene;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScenePrincipal {

    private Button botaoX1,botaoY1,botaoX2,botaoy2,botaoCalc; //Button representa botoes
    private Label textCoordenadaX1,textCoordenadaY1,textCoordenadaX2,textCoordenadaY2; //Label representam rótulos
    private TextField caixaX1,caixaY1,caixaX2,caixaY2,Result, textField2; //TextField Representam áreas de texto
    private float coefAng,coefLin, x1, x2, y1, y2;
    private String result ;
    public void criaScenePrincipal(Stage stage){

        //Criando os labels para os pontos e os campos de texto para os dados
        textCoordenadaX1 = new Label("Informe x1: "); //rótulos
        caixaX1 = new TextField(); //área de texto onde vc digitara alguma coisa

        textCoordenadaY1 = new Label("Informe y1: "); //rótulos
        caixaY1 = new TextField(); //área de texto onde vc digitara alguma coisa

        textCoordenadaX2 = new Label("Informe x2: "); //rótulos
        caixaX2 = new TextField(); //área de texto onde vc digitara alguma coisa

        textCoordenadaY2 = new Label("Informe y2: "); //rótulos
        caixaY2 = new TextField(); //área de texto onde vc digitara alguma coisa


        //HBox é usado para agrupar elementos horizontalmente
        HBox grupoHorizontalx1 = new HBox(textCoordenadaX1, caixaX1); //Passamos no construtor todos os elementos. Você poderá criar vários grupos horizontais
        HBox grupoHorizontaly1 = new HBox(textCoordenadaY1, caixaY1);
        HBox grupoHorizontalx2 = new HBox(textCoordenadaX2, caixaX2); //Passamos no construtor todos os elementos. Você poderá criar vários grupos horizontais
        HBox grupoHorizontaly2 = new HBox(textCoordenadaY2, caixaY2);

        //Agora vamos criar a area que mostrará o que foi digitado
        Result = new TextField();
        Result.setEditable(false);//vamos deixar false para apenas mostrar texto


        //Criamos o botão
        botaoCalc = new Button("Calcular");
        //Criamos a ação que o botão responderá as ser pressionado
        botaoCalc.setOnAction(evento -> {
            //Aqui dentro é a ação que será executado ao pressionar o botão

            x1 = Float.parseFloat(caixaX1.getText());
            x2 = Float.parseFloat(caixaX2.getText());
            y1 = Float.parseFloat(caixaY1.getText());
            y2 = Float.parseFloat(caixaY2.getText());
            if((x2-x1)>0)
            {
                coefAng = (y2-y1)/(x2-x1);
                coefLin = y2 - (x2*coefAng);
                result = "y = ";
                result += coefAng;
                result += "x";
                if(coefLin >= 0){
                    result += " +" + coefLin;
                }
                else{
                    result += " " + coefLin;
                }
            }
            else{
                result = "Divisão por Zero ai em!!!";
            }

            Result.setText(result);
            //botaoCalc.setText("botaoCalc");//Acessamos o componente textField1, pegamos o texto e colocaos em textField2
        });

        //VBox é usada para agrupar elementos verticalmente
        //No construtor passamos todos os elementos que serão agrupados, que podem ser outros grupos
        VBox layoutFinal = new VBox(grupoHorizontalx1, grupoHorizontaly1,grupoHorizontalx2,grupoHorizontaly2,botaoCalc,Result);//Aqui vamos agrupar verticalmente o grupo (Label + Texto) o Botao e A area que aparecer o texto digitado
        //Criamos a Scene
        Scene scene = new Scene(layoutFinal, 300 , 200);

        stage.setTitle("Cálculo da Equação da Reta");
        stage.setScene(scene);
        stage.show();
    }

}
