git add .

echo -n "[+] Enter commit message: "

# shellcheck disable=SC2162
read msg

if [ -z "$msg" ]; then
  echo msg="No commit message"
fi

git commit -m"$msg"

git push -u origin main