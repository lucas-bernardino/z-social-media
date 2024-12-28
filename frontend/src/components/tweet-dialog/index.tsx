import { TweetForm } from "../tweet-form";
import { Dialog, DialogTrigger, DialogContent, DialogHeader, DialogTitle, DialogDescription } from "../ui/dialog";

export default function TweetDialog() {

  return (

    <Dialog>
      <DialogTrigger className="bg-primary p-2 rounded-full text-black font-bold w-full">Postar</DialogTrigger>
      <DialogContent className="border-muted max-w-2xl">
        <TweetForm />
      </DialogContent>
    </Dialog>
  )
}
