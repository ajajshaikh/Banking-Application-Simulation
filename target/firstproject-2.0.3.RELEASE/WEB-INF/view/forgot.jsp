<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
body {font-family: "Times New Roman", Georgia, Serif;}
h1,h2,h3,h4,h5,h6 {
    font-family: "Playfair Display";
    letter-spacing: 5px;
}
</style>
<body>

<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-white w3-padding w3-card" style="letter-spacing:4px;">
    <a href="/firstproject/" class="w3-bar-item w3-button">BANKING APPLICATION</a>
    <!-- Right-sided navbar links. Hide them on small screens -->
    <div class="w3-right w3-hide-small">
		<a href="/firstproject/register" class="w3-bar-item w3-button">REGISTER</a>
    </div>
  </div>
</div>



<div class="w3-container w3-padding-64" id="contact">
    <h3>ENTER USERNAME</h3><br>
    <form action="/firstproject/forgot-password" method="post">
      <p><input class="w3-input w3-padding-16" type="text" placeholder="UserName" required name="username"></p>
      
      <p><button class="w3-button w3-light-grey w3-section" type="submit">SUBMIT</button></p>
    </form>
  </div>
 



</html>