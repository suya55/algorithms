import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.concurrent.*;

public class WordBoggle {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int loop = sc.nextInt();
        for(int i = 0; i < loop; i++){
        	int wordCount = sc.nextInt();
        	Set<String> words = new HashSet<String>();
        	for(int j = 0; j < wordCount ; j++){
        		words.add(sc.next());
        	}
        	int row = sc.nextInt();
        	int col = sc.nextInt();
        	char[][] boggle  = new char[row][col];
        	for(int r = 0 ; r < row ; r++){
        		for(int c = 0 ; c < col ; c++){
		    		boggle[r][c] = sc.next().charAt(0);
		    	}
        	}
        	WordCon wordCon = new WordCon(boggle);
        	ArrayList<String> successWord = new ArrayList<String>();
        	for(String w : words){
        		if(wordCon.search(w)){
        			successWord.add(w);
        		}
        	}
        	Collections.sort(successWord);
        	System.out.println(successWord.isEmpty() ? "-1" : String.join(" ", successWord));
        }
	}

}
class WordCon {
	class Word{
		char word;
		LinkedList<Word> conn;
		boolean visited;
		String key;
		Word(char word,int x, int y){
			this.word = word;
			conn = new LinkedList<Word>();
			visited = false;
			key = x+","+y;
		}
	}
	HashMap<String,Word> wordList;
	HashMap<Character,ArrayList<String>> boggleXY;
	void initWordVisit(){
		for(Word w : wordList.values()){
			w.visited = false;
		}
	}
	void connect(Word w1, Word w2){
		if(!w1.conn.contains(w2)){
			w1.conn.add(w2);
		}
		if(!w2.conn.contains(w1)){
			w2.conn.add(w1);
		}
	}
	WordCon(char[][] boggle){
		this.wordList = new HashMap<String,Word>();
		this.boggleXY = new HashMap<Character,ArrayList<String>>();
	
		for(int i = 0; i< boggle.length; i++){
			for(int j = 0; j< boggle[i].length; j++){
				Word w = new Word(boggle[i][j],i,j);
				wordList.put(w.key,w);
				if(boggleXY.containsKey(w.word)){
					boggleXY.get(w.word).add(w.key);
				}else{
					ArrayList<String> l = new ArrayList<String>();
					l.add(w.key);
					boggleXY.put(w.word,l);
				}
				if(wordList.containsKey((i-1)+","+(j-1))) connect(wordList.get((i-1)+","+(j-1)),w);
				if(wordList.containsKey((i-1)+","+(j  ))) connect(wordList.get((i-1)+","+(j  )),w);
				if(wordList.containsKey((i-1)+","+(j+1))) connect(wordList.get((i-1)+","+(j+1)),w);
				if(wordList.containsKey((i+1)+","+(j-1))) connect(wordList.get((i+1)+","+(j-1)),w);
				if(wordList.containsKey((i+1)+","+(j  ))) connect(wordList.get((i+1)+","+(j  )),w);
				if(wordList.containsKey((i+1)+","+(j+1))) connect(wordList.get((i+1)+","+(j+1)),w);
				if(wordList.containsKey((i  )+","+(j-1))) connect(wordList.get((i  )+","+(j-1)),w);
				if(wordList.containsKey((i  )+","+(j+1))) connect(wordList.get((i  )+","+(j+1)),w);

			}
		}
	}

	boolean search(String word){
		// System.out.println("search : "+word);
		LinkedBlockingQueue<Word> q = new LinkedBlockingQueue<Word>();
		char[] wc = word.toCharArray();
		initWordVisit();
		if(boggleXY.containsKey(word.charAt(0))){

			for(String k : boggleXY.get(word.charAt(0))){
				// System.out.println("boggleXY("+word.charAt(0)+") : "+k);
				int index = 0;
				Word start = wordList.get(k);
				q.add(start);

				while(!q.isEmpty()){
					Word current = q.poll();
					current.visited = true;
					if(wc[index] == current.word ){
						index++;

					}
					if(index >= wc.length){
						return true;
					}
					for(Word w : current.conn){
						if(wc[index] == w.word && !w.visited){
							q.add(w);
						}
					}
					// System.out.println(current.word);
					
				}
				
			}

		}
		return false;
		
	}
}