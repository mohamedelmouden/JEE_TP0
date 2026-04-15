<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inventory Management</title>
    <style>
        body { font-family: Arial, sans-serif; display: flex; justify-content: center;
               align-items: center; height: 100vh; margin: 0; background: #f0f2f5; }
        .card { background: white; padding: 40px 60px; border-radius: 10px;
                box-shadow: 0 4px 12px rgba(0,0,0,0.1); text-align: center; }
        h1 { color: #333; margin-bottom: 30px; }
        a.btn { display: inline-block; margin: 10px; padding: 14px 28px;
                text-decoration: none; color: white; border-radius: 5px; font-size: 16px; }
        .btn-green { background: #4CAF50; }
        .btn-blue  { background: #2196F3; }
    </style>
</head>
<body>
<div class="card">
    <h1>🏪 Inventory Management</h1>
    <p>Bienvenue dans l'application de gestion d'inventaire.</p>
    <a class="btn btn-green" href="users">👤 Gérer les utilisateurs</a>
    <a class="btn btn-blue"  href="items">📦 Gérer le stock</a>
</div>
</body>
</html>
