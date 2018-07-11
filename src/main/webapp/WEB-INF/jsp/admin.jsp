<!DOCTYPE html>
<html lang="en">
<body>

<style>
  .left{float:left; width:50%;}
</style>

<div class="left">
    <p>Add Inventory:</p>
    <form action="/addInventory" method="post">
        <p>Ingredient type:</p>
        <select id="type" name="type">
            <option value="size">size</option>
            <option value="sauce">sauce</option>
            <option value="cheese">cheese</option>
            <option value="topping">topping</option>
        </select>
        <p>name:</p>
        <input name="name"/>
        <br>
        <p>price:</p>
        <input type="number" name="price"/>
        <br>
        <br>
        <input type="submit" value="Add">
    </form>
</div>

<div class="left">
    <p>Delete Inventory:</p>
    <form action="/deleteInventory" method="post">
        <p>Ingredient type:</p>
        <select id="type" name="type">
            <option value="size">size</option>
            <option value="sauce">sauce</option>
            <option value="cheese">cheese</option>
            <option value="topping">topping</option>
        </select>
        <p>name:</p>
        <input name="name"/>
        <br>
        <br>
        <input type="submit" value="Delete">
    </form>
</div>

</body>
</html>