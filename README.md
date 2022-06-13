# 課題 12-2: 日付

### 課題の説明

バイオテクノロジー実習の資料に目を通していたところ、「試料の準備を終えてから反応が完了するまで
31時間インキュベータ内に放置してから観察する」と書かれていた。しかし、暗算でその時刻を計算して
間違うと再実験になってしまう。
そこで、クラスObservationを定義し、「練習問題15-4の問題と解答のコード」
および「実行結果の例」を参考にして、プログラムが起動した時刻から31時間後の時刻を「7/3 18時22分05秒」
(時、分、秒は2ケタ表示)の形式にした文字列を返すメソッドを作成しなさい。


| フィールド名   | 型   | 初期値 | アクセス修飾子 |
|----------|-----|-----|-----------------|
| waitHour | int | 0   | public  | 

| メソッド名           | 引数のリスト   | 戻り値の型  | アクセス修飾子 |
|-----------------|----------|--------|--------|
| getReactionTime | Date now | String | public | 

### ProgC2.java (変更・提出不要)
```java
import java.util.Date;

public class ProgC2 {

    public static void main(String[] args) {
        Observation o = new Observation();
        o.waitHour = 31;
        Date now = new Date();
        System.out.println(o.getReactionTime(now));
    }

}
```

### 実行結果の例 （7月2日11時22分05秒 にプログラムを起動した場合）
```
7/3 18時22分05秒
```
