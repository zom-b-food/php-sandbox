
<!DOCTYPE html>

<html lang="en">

<head>

    <script type="text/javascript" src="./resources/js/jquery-2.1.1.js"></script>
    <script type="text/javascript" src="./resources/js/jquery.html5Loader.min.js"></script>
    <script type="text/javascript">
        /*
         $(function () {
         $.preloadimg = function() {
         for (var i = 0; i < arguments.length; i++) {
         $("<img />").attr("src", arguments[i]);
         }
         }
         });


         $.preloadimg("images/background.jpg");
         */
        var t = (new Date).getTime();
        var files = [


            {
                "type":"CSS",
                "source":"./resources/compiled/php-sandbox.min.css",
                "size":5.5
            },

            {
                "type":"SCRIPT",
                "source":"./resources/compiled/php-sandbox.min.js",
                "size":5.8,
                "stopExecution":false
            }
        ];

        $.html5Loader({
            filesToLoad: {"files": files},
            stopExecution: true,
            onElementLoaded: function ( obj, elm ) {
                var source = obj.source.split('/');
                console.log( source[source.length-1].split('.js')[0] );
            },
            onComplete: function () {
                console.log("%c\n All assets loaded! ", "background: #222; color: #bada55");
            }
        });


        function autotab(original, destination) {
            if (original.getAttribute && original.value.length == original.getAttribute("maxlength"))destination.focus()
        }

        $(window).load(function(){
            $('#dvLoading').fadeOut(1400);
        });
    </script>
    <style type="text/css">
        #dvLoading
        {
            background:#fff url(resources/images/ui/bx_loader.gif) no-repeat center center;
            height: 200px;
            width: 200px;
            position: fixed;
            z-index: 1000;
            left: 50%;
            top: 50%;
            margin: -25px 0 0 -25px;
        }
    </style>
</head>

<body>
<div id="dvLoading"></div>

</body>
<script type="text/javascript">
    $(window).load(function () {
        window.setTimeout(function () {
            window.location.href = "pages/index.php";
        }, 1400)
    });



</SCRIPT>
</html>