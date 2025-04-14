// script.js
document.addEventListener('DOMContentLoaded', function() {
    console.log('ログインページが読み込まれました');
});

<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1.5.1/dist/sockjs.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/stompjs@2.3.3/lib/stomp.min.js"></script>

<script>
    const socket = new SockJS('/ws');
    const stompClient = Stomp.over(socket);

    stompClient.connect({}, () => {
        stompClient.subscribe('/topic/stock', (message) => {
            const data = JSON.parse(message.body);
            console.log("在庫更新:", data);
            // ここでDOM更新
        });
    });
</script>

<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/stompjs@2.3.3/lib/stomp.min.js"></script>

<script>
    const socket = new SockJS('/ws');
    const stompClient = Stomp.over(socket);

    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);

        stompClient.subscribe('/topic/stock', function (message) {
            const data = JSON.parse(message.body);
            const productId = data.productId;
            const stockQty = data.stockQty;

            const stockElement = document.getElementById(`product-${productId}-stock`);
            if (stockElement) {
                stockElement.textContent = stockQty;
                stockElement.style.color = 'red'; // 見やすく変化
                setTimeout(() => stockElement.style.color = '', 1500); // 元に戻す
            }
        });
    });
</script>

<script src="https://cdn.jsdelivr.net/npm/sockjs-client/dist/sockjs.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/stompjs/lib/stomp.min.js"></script>
<script>
    const socket = new SockJS('/ws');
    const stompClient = Stomp.over(socket);

    stompClient.connect({}, function () {
        stompClient.subscribe('/topic/inventory', function (message) {
            const data = JSON.parse(message.body);
            alert("商品ID: " + data.productId + " の在庫が " + data.quantity + " に更新されました！");
            // 必要に応じてDOMを更新する処理を書く
        });
    });
</script>


