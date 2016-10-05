<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
    <head>
        <title> new document </title>
<script>
<!--

function fncGetNumber()
{
    var nums = new Array();
    nums.push( (parseInt(Math.random()*450)%45+1) );

    while(true)
    {
        if( nums.length < 6 )
        {
            var flg = true;
            var num = parseInt(Math.random()*450)%45+1;

            for( var i=0; i<nums.length; i++ )
            {
                if( num == nums[i] )
                    flg = false;
            }

            if( flg )
                nums.push( num );
        }
        else
        {
            break;
        }
    }


    var str = '';
    for( var j=0; j<nums.length; j++ )
    {
        if( j== 0 )
            str = nums[j];
        else
            str += ',' + nums[j];
    }

    document.getElementById('disp').innerHTML = str;
}

//-->
</script>
</head>
    <body>
		<form name='frm'>

<div id='disp'></div>

<input type='button' name='btn' value='Click' onclick='javascript:fncGetNumber();'>

		</form>
    </body>
</html>
