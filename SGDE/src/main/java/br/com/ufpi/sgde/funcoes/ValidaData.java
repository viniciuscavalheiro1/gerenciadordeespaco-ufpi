/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufpi.sgde.funcoes;

/**
 *
 * @author pedro
 */
public class ValidaData {
    public static String validar(String data){
        
        String[] quebra = data.split(" ");
            if (quebra[1].equals("Jan")){
                return quebra[2]+"/"+"01/"+quebra[5];              
            }if (quebra[1].equals("Fev")){
                return quebra[2]+"/"+"02/"+quebra[5];              
            }if (quebra[1].equals("Mar")){
                return quebra[2]+"/"+"03/"+quebra[5];              
            }if (quebra[1].equals("Abr")){
                return quebra[2]+"/"+"04/"+quebra[5];              
            }if (quebra[1].equals("Mai")){
                return quebra[2]+"/"+"05/"+quebra[5];              
            }if (quebra[1].equals("Jun")){
                return quebra[2]+"/"+"06/"+quebra[5];              
            }if (quebra[1].equals("Jul")){
                return quebra[2]+"/"+"07/"+quebra[5];              
            }if (quebra[1].equals("Ago")){
                return quebra[2]+"/"+"08/"+quebra[5];              
            }if (quebra[1].equals("Set")){
                return quebra[2]+"/"+"09/"+quebra[5];              
            }if (quebra[1].equals("Out")){
                return quebra[2]+"/"+"10/"+quebra[5];              
            }if (quebra[1].equals("Nov")){
                return quebra[2]+"/"+"11/"+quebra[5];              
            }else{
                return quebra[2]+"/"+"12/"+quebra[5];              
            }
        
    }
    
}
