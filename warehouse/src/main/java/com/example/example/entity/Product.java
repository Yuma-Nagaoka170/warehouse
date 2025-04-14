/*1. 在庫管理機能
リアルタイム在庫追跡: 倉庫内の在庫レベル、状態、位置をリアルタイムで追跡。

バーコード/QRコードスキャン: 入庫、出庫、移動を正確に記録するためのスキャン機能。

ロット管理: シリアル番号、製造日、期限などの属性情報をログ。

在庫アラート: 最低在庫レベルに達した場合の通知。

2. 倉庫内ロケーション管理
ロケーションID: 倉庫内の棚やゾーンを識別するユニークID。

ゾーン分類: ピッキングエリア、バルクエリア、冷蔵/冷凍エリアなどの分類。

倉庫マップ表示: 倉庫全体のレイアウトと在庫状況を視覚化。

3. 受入・出荷プロセス
受入管理: 入庫品の検品と登録。

出荷管理: 注文に基づくピッキング、梱包、配送手配。

クロスドッキング: 入荷品を直接出荷する効率的なプロセス。

4. 注文管理
注文処理: 注文作成から追跡、履行までの管理。

返品処理: 返品された商品の登録と再入庫プロセス。

マルチチャネル統合: ECサイトやPOSシステムとの連携。

5. 自動化と最適化
ピッキング最適化: ピッキングリストの生成と最短ルートの提案。

需要予測: 過去データに基づく需要予測と在庫補充提案。

タスク自動化: 入出庫プロセスや棚卸し作業の自動化。

6. レポートと分析
レポート生成: 在庫状況、注文履行率、返品率などの統計データ。

分析ツール: パフォーマンスギャップやトレンド分析による改善提案。

7. セキュリティとアクセス制御
ユーザー権限管理: 各ユーザーに対して適切なアクセス権限を設定。

監視システム連携: 倉庫内の安全性を確保するための監視カメラやセンサーとの統合。

8. モバイル対応
スマートフォンやタブレットで操作可能なインターフェース。

現場での迅速なデータ入力や確認が可能。*/


package com.example.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String sku;  // 商品コード（SKU）

    @Column(nullable = false)
    private double price;

	public int getQuantity() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	public void setQuantity(int i) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}


