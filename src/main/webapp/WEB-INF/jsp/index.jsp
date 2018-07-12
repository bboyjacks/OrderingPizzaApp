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
            var select_sizes_tag = document.getElementById("select-size");

            for (var key in json_response.m_size_to_price_map) {
                if (json_response.m_size_to_price_map.hasOwnProperty(key)) {
                    var node = document.createElement("li");
                    var item = key + '      $' + json_response.m_size_to_price_map[key];
                    var textnode1 = document.createTextNode(item);
                    node.appendChild(textnode1);
                    sizes_tag.appendChild(node);

                    var select_node = document.createElement("option");
                    select_node.setAttribute("value", key);
                    var textnode2 = document.createTextNode(key);
                    select_node.appendChild(textnode2);
                    select_sizes_tag.appendChild(select_node);
                }
            }
        });

        httpGetAsync("/sauce", function(response)
        {
            var json_response = JSON.parse(response);
            console.log(json_response);

            var sauce_tag = document.getElementById("sauce");
            var select_sauce_tag = document.getElementById("select-sauce");

            for (var key in json_response.m_sauce_to_price_map) {
                if (json_response.m_sauce_to_price_map.hasOwnProperty(key)) {
                    var node = document.createElement("li");
                    var item = key + '      $' + json_response.m_sauce_to_price_map[key];
                    var textnode1 = document.createTextNode(item);
                    node.appendChild(textnode1);
                    sauce_tag.appendChild(node);

                    var select_node = document.createElement("option");
                    select_node.setAttribute("value", key);
                    var textnode2 = document.createTextNode(key);
                    select_node.appendChild(textnode2);
                    select_sauce_tag.appendChild(select_node);
                }
            }
        });

        httpGetAsync("/topping", function(response)
        {
            var json_response = JSON.parse(response);
            console.log(json_response);

            var toppings_tag = document.getElementById("topping");

            for (var key in json_response.m_topping_to_price_map) {
                if (json_response.m_topping_to_price_map.hasOwnProperty(key)) {
                    var node = document.createElement("li");
                    var item = key + '      $' + json_response.m_topping_to_price_map[key];
                    var textnode1 = document.createTextNode(item);
                    node.appendChild(textnode1);
                    toppings_tag.appendChild(node);
                }
            }
        });

        httpGetAsync("/cheese", function(response)
        {
            var json_response = JSON.parse(response);
            console.log(json_response);

            var cheese_tag = document.getElementById("cheese");
            var select_cheese_tag = document.getElementById("select-cheese");

            for (var key in json_response.m_cheese_to_price_map) {
                if (json_response.m_cheese_to_price_map.hasOwnProperty(key)) {
                    var node = document.createElement("li");
                    var item = key + '      $' + json_response.m_cheese_to_price_map[key];
                    var textnode1 = document.createTextNode(item);
                    node.appendChild(textnode1);
                    cheese_tag.appendChild(node);

                    var select_node = document.createElement("option");
                    select_node.setAttribute("value", key);
                    var textnode2 = document.createTextNode(key);
                    select_node.appendChild(textnode2);
                    select_cheese_tag.appendChild(select_node);
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
        <select id="select-size" name="size">
        </select>
        <br>
        <p>Sauce:</p>
        <select id="select-sauce" name="sauce">
        </select>
        <br>
        <p>Cheese:</p>
        <select id="select-cheese" name="cheese">
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