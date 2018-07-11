<!DOCTYPE html>
<html lang="en">
<body>

<style>
  .left{float:left; width:50%;}
</style>

<script type="text/javascript">

    function httpGetAsync(theUrl, callback)
    {
        var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function() {
            if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
                callback(xmlHttp.responseText);
        }
        xmlHttp.open("GET", theUrl, true); // true for asynchronous
        xmlHttp.send(null);
    }

    document.addEventListener("DOMContentLoaded", function(event) {
        httpGetAsync("/sizes", function(response)
        {
            var json_response = JSON.parse(response);
            console.log(json_response);

            var sizes_tag = document.getElementById("sizes");

            for (var key in json_response.m_size_to_price_map) {
                if (json_response.m_size_to_price_map.hasOwnProperty(key)) {
                    var node = document.createElement("li");
                    var textnode = document.createTextNode(key);
                    node.appendChild(textnode);
                    sizes_tag.appendChild(node);
                }
            }
        });

        httpGetAsync("/sauce", function(response)
        {
            var json_response = JSON.parse(response);
            console.log(json_response);

            var sizes_tag = document.getElementById("sauce");

            for (var key in json_response.m_sauce_to_price_map) {
                if (json_response.m_sauce_to_price_map.hasOwnProperty(key)) {
                    var node = document.createElement("li");
                    var textnode = document.createTextNode(key);
                    node.appendChild(textnode);
                    sizes_tag.appendChild(node);
                }
            }
        });

        httpGetAsync("/topping", function(response)
        {
            var json_response = JSON.parse(response);
            console.log(json_response);

            var sizes_tag = document.getElementById("topping");

            for (var key in json_response.m_topping_to_price_map) {
                if (json_response.m_topping_to_price_map.hasOwnProperty(key)) {
                    var node = document.createElement("li");
                    var textnode = document.createTextNode(key);
                    node.appendChild(textnode);
                    sizes_tag.appendChild(node);
                }
            }
        });

        httpGetAsync("/cheese", function(response)
        {
            var json_response = JSON.parse(response);
            console.log(json_response);

            var sizes_tag = document.getElementById("cheese");

            for (var key in json_response.m_cheese_to_price_map) {
                if (json_response.m_cheese_to_price_map.hasOwnProperty(key)) {
                    var node = document.createElement("li");
                    var textnode = document.createTextNode(key);
                    node.appendChild(textnode);
                    sizes_tag.appendChild(node);
                }
            }
        });
    });
</script>

<div class="left">
    <p>Sizes:</p>
    <ol id="sizes">
    </ol>
    <p>Sauce Options:</p>
    <ol id="sauce">
    </ol>
    <p>Cheese Options:</p>
    <ol id="cheese">
    </ol>
    <p>Topping Options:</p>
    <ol id="topping">
    </ol>
</div>
<div class="left">
    <p>Order:</p>
    <form action="/order" method="get">
        <p>Sizes:</p>
        <select name="size">
            <option value="small">small</option>
            <option value="medium">medium</option>
            <option value="large">large</option>
        </select>
        <br>
        <p>Sauce:</p>
        <select name="sauce">
            <option value="marinara">marinara</option>
            <option value="pesto">pesto</option>
            <option value="alfredo">alfredo</option>
        </select>
        <br>
        <p>Cheese:</p>
        <select name="cheese">
            <option value="pepperjack">pepperjack</option>
            <option value="swiss">swiss</option>
            <option value="cheddar">cheddar</option>
        </select>
        <br>
        <p>Topping:</p>
        <input type="text" name="topping"/>
        <br>
        <br>
        <input type="submit" value="Order">
    </form>
</div>
</body>
</html>