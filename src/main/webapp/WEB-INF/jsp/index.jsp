<!DOCTYPE html>
<html lang="en">
<body>

<style>
  .left{float:left; width:50%;}
</style>

<div class="left">
    <p>Sizes:</p>
    <ol>
        <li>small</li>
        <li>medium</li>
        <li>large</li>
    </ol>
    <p>Sauce Options:</p>
    <ol>
        <li>marinara</li>
        <li>pesto</li>
        <li>alfredo</li>
    </ol>
    <p>Cheese Options:</p>
    <ol>
        <li>pepperjack</li>
        <li>swiss</li>
        <li>cheddar</li>
    </ol>
    <p>Topping Options:</p>
    <ol>
        <li>pepperoni</li>
        <li>olives</li>
        <li>pineapple</li>
        <li>ham</li>
        <li>sausage</li>
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