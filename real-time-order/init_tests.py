dot_env = """DB_URL=www.djpiper28.co.uk
DB_PORT=6445
DB_USERNAME=dev
DB_PASSWORD=group_5_verysecure
DB_NAME=teamdev
BIND_ADDR=127.0.0.1
BIND_PORT=8010
JWT_SECRET=y4ZOnt3FchYFjPsYXEjz4ApV0hlBqNtyJNGe1RFoLiV7G8QnbGKhfN0aej8qtwuLBLXDaxC3QTBrnaWCMyq48p5fu5hy961HFmM8iGvSnnIMXz4LlZHEA1UTePm8ntPB2T6YNR2sQb0aJ210PEnph5SkEdNwZA4dEbq5fpzPiWg9kaYZOD8mdf2pbGsudrjDngYPnMiYfxWTE7s0YibKlgNJ18XDcdt6O2etkWULxKJMVeRtgkLtfWwsn
"""

f = open(".env", "w")
f.write(dot_env)
f.close()

f = open("utils/.env", "w")
f.write(dot_env)
f.close()
